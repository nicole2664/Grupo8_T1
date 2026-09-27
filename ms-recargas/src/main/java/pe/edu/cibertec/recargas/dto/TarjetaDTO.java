package pe.edu.cibertec.recargas.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TarjetaDTO {
    private Long idTarjeta;
    private String nomTitular;
    private BigDecimal saldoAsignado;
    private BigDecimal saldoDisponible;
}
