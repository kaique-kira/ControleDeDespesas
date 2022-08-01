package br.com.kira.ControleDeDespesas.Controller;

import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    private ReceitasService receitasService;


    @PostMapping("receitas")
    public ResponseEntity<ReceitasDTO> create(@RequestBody ReceitasDTO receita){
        ReceitasEntity receitasEntity = receita.toEntity();

        ReceitasEntity receitasEntitySalvo = this.receitasService.create(receitasEntity);

        return ResponseEntity.ok().body(receitasEntitySalvo.toDTO());
    }


    @GetMapping("receitas")
    public ResponseEntity<List<ReceitasDTO>> getAll() {
        List<ReceitasEntity> lista = this.receitasService.getAll();

        List<ReceitasDTO> listaDTO = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            listaDTO.add( lista.get(i).toDTO() );
        }

        List<ReceitasDTO> listaDTO2 = lista.stream()
                .map( x -> x.toDTO()).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }

}
