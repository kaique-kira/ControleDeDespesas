package br.com.kira.ControleDeDespesas.Entity;

import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


    private LocalDate data;

    public ReceitasDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasDTO.class);
    }
}
