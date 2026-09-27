package pe.edu.cibertec.recargas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.recargas.dto.RecargaRequestDTO;
import pe.edu.cibertec.recargas.entity.Recarga;
import pe.edu.cibertec.recargas.service.RecargaService;

@RestController
@RequestMapping("/api/recargas")
public class RecargaController {

    private final RecargaService service;

    public RecargaController(RecargaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Recarga> registrar(@RequestBody RecargaRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarRecarga(request));
    }
}