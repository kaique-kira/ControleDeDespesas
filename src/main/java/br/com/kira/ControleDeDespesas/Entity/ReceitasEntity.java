package br.com.kira.ControleDeDespesas.Entity;

import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
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
@Table(name = "receitas")
public class ReceitasEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;

    private double valor;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime data;


    public ReceitasDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasDTO.class);
    }
}
