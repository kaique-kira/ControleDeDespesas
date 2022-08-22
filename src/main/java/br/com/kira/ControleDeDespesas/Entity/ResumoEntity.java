package br.com.kira.ControleDeDespesas.Entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumo")
public class ResumoEntity {
	
	private LocalDate anoMes;
	private Double valorTotalDespesas = 0D;
	private Double valorTotalReceitas = 0D;
	private Double saldo;

	
	
	public ResumoDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ResumoDTO.class);
    }
	

}
