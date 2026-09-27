package pe.edu.cibertec.tarjetas.controller;

import pe.edu.cibertec.tarjetas.dto.TarjetaResponseDTO;
import pe.edu.cibertec.tarjetas.service.TarjetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {

    private final TarjetaService tarjetaService;

    @GetMapping
    public ResponseEntity<List<TarjetaResponseDTO>> listarTarjetas() {
        return ResponseEntity.ok(tarjetaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarjetaResponseDTO> consultarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tarjetaService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}