package pe.edu.cibertec.recargas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.cibertec.recargas.dto.TarjetaDTO;

@FeignClient(name = "ms-tarjetas", url = "${feign.tarjetas.url}")
public interface TarjetaFeignClient {

    @GetMapping("/api/tarjetas/{id}")
    TarjetaDTO obtenerTarjetaPorId(@PathVariable("id") Long id);
}
