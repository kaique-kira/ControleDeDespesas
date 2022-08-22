package br.com.kira.ControleDeDespesas.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	
	private LocalDate anoMes;
	private Double valorTotalDespesas = 0D;
	private Double valorTotalReceitas = 0D;
	private Double saldo;

	
	public ResumoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ResumoEntity.class);
	}

}
