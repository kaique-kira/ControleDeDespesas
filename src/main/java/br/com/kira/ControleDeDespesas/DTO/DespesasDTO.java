package br.com.kira.ControleDeDespesas.DTO;

import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

public class DespesasDTO {

    private int id;
    private String descricao;
    private double valor;
    private LocalDateTime data;


    public DespesasEntity toEntity(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, DespesasEntity.class);
    }
}
