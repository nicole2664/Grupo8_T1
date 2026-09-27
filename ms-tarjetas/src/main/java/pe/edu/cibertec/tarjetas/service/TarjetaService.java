package pe.edu.cibertec.tarjetas.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.tarjetas.entity.Tarjeta;
import pe.edu.cibertec.tarjetas.repository.TarjetaRepository;

import java.util.List;

public interface TarjetaService {
    Tarjeta registrar(Tarjeta tarjeta);
    List<Tarjeta> listarTodos();
    Tarjeta obtenerPorId(Long id);
}

@Service
class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository repository;

    public TarjetaServiceImpl(TarjetaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tarjeta registrar(Tarjeta tarjeta) {
        return repository.save(tarjeta);
    }

    @Override
    public List<Tarjeta> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Tarjeta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada con ID: " + id));
    }
}
