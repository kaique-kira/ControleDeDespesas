package br.com.kira.ControleDeDespesas.DTO;

import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitasDTO {

    private int id;

    @NotEmpty( message = "O campo nome é obrigatório" )
    @NotBlank( message = "o campo nome não pode ser vazio")
    @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres")
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    private enum categorias {
        ALIMENTAÇÃO, SAÚDE, MORADIA, TRANSPORTE, EDUCAÇÃO, LAZER, IMPREVISTOS, 
    }

    public ReceitasEntity toEntity(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasEntity.class);
    }
}
