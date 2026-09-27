package pe.edu.cibertec.tarjetas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tarjetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long idTarjeta;

    @Column(name = "nom_titular", nullable = false, length = 100)
    private String nomTitular;

    @Column(name = "saldo_asignado", nullable = false)
    private BigDecimal saldoAsignado;

    @Column(name = "saldo_disponible", nullable = false)
    private BigDecimal saldoDisponible;
}