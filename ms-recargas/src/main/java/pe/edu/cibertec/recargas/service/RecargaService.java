package pe.edu.cibertec.recargas.service;

import feign.FeignException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.recargas.client.TarjetaFeignClient;
import pe.edu.cibertec.recargas.dto.RecargaRequestDTO;
import pe.edu.cibertec.recargas.dto.TarjetaDTO;
import pe.edu.cibertec.recargas.entity.Recarga;
import pe.edu.cibertec.recargas.repository.RecargaRepository;

import java.time.LocalDateTime;

@Service
public class RecargaService {

    private final RecargaRepository recargaRepository;
    private final TarjetaFeignClient tarjetaFeignClient;

    public RecargaService(RecargaRepository recargaRepository, TarjetaFeignClient tarjetaFeignClient) {
        this.recargaRepository = recargaRepository;
        this.tarjetaFeignClient = tarjetaFeignClient;
    }

    public Recarga registrarRecarga(RecargaRequestDTO request) {
        TarjetaDTO tarjeta;

        // 1. Validación sincrónica vía OpenFeign
        try {
            tarjeta = tarjetaFeignClient.obtenerTarjetaPorId(request.getIdTarjeta());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("La tarjeta con ID " + request.getIdTarjeta() + " no existe.");
        } catch (Exception e) {
            throw new RuntimeException("Error al comunicarse con el servicio de Tarjetas: " + e.getMessage());
        }

        // 2. Mapeo e inserción con la fecha del sistema y saldo disponible del ms-tarjetas
        Recarga recarga = Recarga.builder()
                .idTarjeta(tarjeta.getIdTarjeta())
                .saldoDisponible(tarjeta.getSaldoDisponible())
                .montoRecarga(request.getMontoRecarga())
                .fechaRecarga(LocalDateTime.now()) // Generación automática de fecha
                .build();

        return recargaRepository.save(recarga);
    }
}
