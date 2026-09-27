package pe.edu.cibertec.tarjetas.controller;

import pe.edu.cibertec.tarjetas.entity.Tarjeta;
import pe.edu.cibertec.tarjetas.service.TarjetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    private final TarjetaService service;

    public TarjetaController(TarjetaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarjeta> registrar(@RequestBody Tarjeta tarjeta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(tarjeta));
    }

    @GetMapping
    public ResponseEntity<List<Tarjeta>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarjeta> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}
