package br.com.kira.ControleDeDespesas.DTO;

import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    private enum categorias {
        ALIMENTAÇÃO, SAÚDE, MORADIA, TRANSPORTE, EDUCAÇÃO, LAZER, IMPREVISTOS, 
    }

    public ReceitasEntity toEntity(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasEntity.class);
    }
    
    public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
    public ReceitasDTO(int id,
			@NotEmpty(message = "O campo nome é obrigatório") @NotBlank(message = "o campo nome não pode ser vazio") @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres") String descricao,
			BigDecimal valor, LocalDate data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public ReceitasDTO() {
		super();
	}
    
    

}
