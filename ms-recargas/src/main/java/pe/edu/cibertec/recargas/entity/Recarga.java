package pe.edu.cibertec.recargas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recargas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recarga")
    private Long idRecarga;

    @Column(name = "id_tarjeta", nullable = false)
    private Long idTarjeta;

    @Column(name = "saldo_disponible", nullable = false)
    private BigDecimal saldoDisponible;

    @Column(name = "monto_recarga", nullable = false)
    private BigDecimal montoRecarga;

    @Column(name = "fecha_recarga", nullable = false)
    private LocalDateTime fechaRecarga;
}
