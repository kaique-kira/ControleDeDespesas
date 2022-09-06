package br.com.kira.ControleDeDespesas.DTO;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.Entity.ResumoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumoDTO {
	
	private BigDecimal totalReceitas;
	private BigDecimal totalDespesas;
	private BigDecimal saldo;
	private List<DespesasDTO> gastoTotalPorCategoria;

	
	public ResumoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ResumoEntity.class);
	}

}
