package pe.edu.cibertec.recargas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.recargas.entity.Recarga;

@Repository
public interface RecargaRepository extends JpaRepository<Recarga, Long> {
}