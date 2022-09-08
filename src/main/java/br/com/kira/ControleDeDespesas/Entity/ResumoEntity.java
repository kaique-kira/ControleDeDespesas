package br.com.kira.ControleDeDespesas.Entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumo")
public class ResumoEntity {
	
	@Id
	private Integer id;
	private BigDecimal totalReceitas;
	private BigDecimal totalDespesas;
	private BigDecimal saldo;
	
	@OneToOne
	private List<DespesasEntity> categoria;

	public ResumoEntity(LocalDate startDate, LocalDate endDate, 
			ReceitasRepository receitaRepository, DespesasRepository despesaRepository) {
		
		this.totalReceitas = receitaRepository.sumBetweenData(startDate, endDate).or(BigDecimal.ZERO);
		this.totalDespesas = despesaRepository.sumBetweenData(startDate, endDate).or(BigDecimal.ZERO);
		this.saldo = this.totalReceitas.subtract(this.totalDespesas);
		this.categoria = despesaRepository.countTotalDespesaByCategoryBetweenData(startDate, endDate);
	}
	
	public ResumoDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ResumoDTO.class);
    }
	

}
