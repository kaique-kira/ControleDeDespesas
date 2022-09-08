package br.com.kira.ControleDeDespesas.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ResumoEntity;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;
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
	private List<DespesasEntity> categoria;

	
	

	public ResumoDTO(LocalDate startDate, LocalDate endDate, 
			ReceitasRepository receitaRepository, DespesasRepository despesaRepository) {
		
		this.totalReceitas = receitaRepository.sumBetweenData(startDate, endDate).or(BigDecimal.ZERO);
		this.totalDespesas = despesaRepository.sumBetweenData(startDate, endDate).or(BigDecimal.ZERO);
		this.saldo = this.totalReceitas.subtract(this.totalDespesas);
		this.categoria = despesaRepository.countTotalDespesaByCategoryBetweenData(startDate, endDate);
	}
	
	public ResumoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ResumoEntity.class);
	}

}
