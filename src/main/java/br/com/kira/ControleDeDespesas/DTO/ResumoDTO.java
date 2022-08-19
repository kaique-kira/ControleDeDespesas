package br.com.kira.ControleDeDespesas.DTO;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.Entity.ResumoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumoDTO {
	
	private BigDecimal valorTotalMesReceita;
	
	private BigDecimal valorTotalMesDespesas;
	
	private BigDecimal saldoFinal;
	
	private BigDecimal valorTotalGastoCategoria;
	
	public ResumoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ResumoEntity.class);
	}

}
