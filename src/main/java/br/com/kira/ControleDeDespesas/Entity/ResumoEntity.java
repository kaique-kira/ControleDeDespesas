package br.com.kira.ControleDeDespesas.Entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumo")
public class ResumoEntity {
	
	private BigDecimal totalReceitas;
	private BigDecimal totalDespesas;
	private BigDecimal saldo;
	private List<DespesasEntity> gastoTotalPorCategoria;

	
	
	public ResumoDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ResumoDTO.class);
    }
	

}
