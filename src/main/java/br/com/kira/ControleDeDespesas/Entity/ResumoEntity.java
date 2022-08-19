package br.com.kira.ControleDeDespesas.Entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumoEntity {
	
	private BigDecimal valorTotalMesReceita;
	
	private BigDecimal valorTotalMesDespesas;
	
	private BigDecimal saldoFinal;
	
	private BigDecimal valorTotalGastoCategoria;
	
	
	public ResumoDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ResumoDTO.class);
    }
	

}
