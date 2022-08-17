package br.com.kira.ControleDeDespesas.Entity;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "despesas")
public class DespesasEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty( message = "O campo nome é obrigatório" )
    @NotBlank( message = "o campo nome não pode ser vazio")
    @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres")
    private String descricao;

    private BigDecimal valor;


    private LocalDate data;

    @Column(name = "categoria", columnDefinition = "enum('Alimentação', 'Saúde', 'Moradia', 'Transporte', 'Educação', 'Lazer', 'Imprevistos', 'Outros')")
    private String categoria;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public DespesasDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, DespesasDTO.class);
    }

	public DespesasEntity(int id,
			@NotEmpty(message = "O campo nome é obrigatório") @NotBlank(message = "o campo nome não pode ser vazio") @Length(min = 3, message = "O campo nome deve possuir pelo menos 3 caracteres") String descricao,
			BigDecimal valor, LocalDate data, String categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
	}

	public DespesasEntity() {
		super();
	}
    
    

}
