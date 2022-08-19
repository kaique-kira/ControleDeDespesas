package br.com.kira.ControleDeDespesas.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "receitas")
public class ReceitasEntity {



	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty( message = "O campo nome é obrigatório" )
    @NotBlank( message = "o campo nome não pode ser vazio")
    @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres")
    private String descricao;

	private BigDecimal valor;

	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    

    public ReceitasDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasDTO.class);
    }

	
}
