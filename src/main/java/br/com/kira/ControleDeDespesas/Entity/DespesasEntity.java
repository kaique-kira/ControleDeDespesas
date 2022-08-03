package br.com.kira.ControleDeDespesas.Entity;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "despesas")
public class DespesasEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private double valor;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime data;

    public DespesasDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, DespesasDTO.class);
    }


}
