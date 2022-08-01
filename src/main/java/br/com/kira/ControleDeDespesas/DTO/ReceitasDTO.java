package br.com.kira.ControleDeDespesas.DTO;


import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

public class ReceitasDTO {

    private int id;
    private String descricao;
    private double valor;
    private LocalDateTime data;

    public ReceitasEntity toEntity(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, ReceitasEntity.class);
    }
}
