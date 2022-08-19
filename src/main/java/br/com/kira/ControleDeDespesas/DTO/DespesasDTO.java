package br.com.kira.ControleDeDespesas.DTO;

import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DespesasDTO {

    private int id;

    @NotEmpty( message = "O campo nome é obrigatório" )
    @NotBlank( message = "o campo nome não pode ser vazio")
    @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres")
    private String descricao;
    private BigDecimal valor;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    @Column(name = "categoria", columnDefinition = "enum('Alimentação', 'Saúde', 'Moradia', 'Transporte', 'Educação', 'Lazer', 'Imprevistos', 'Outros')")
    private String categoria;

    public DespesasEntity toEntity(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, DespesasEntity.class);
    }

	
    
    
}
