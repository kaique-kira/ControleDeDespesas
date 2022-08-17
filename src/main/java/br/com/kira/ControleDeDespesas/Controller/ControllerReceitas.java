package br.com.kira.ControleDeDespesas.Controller;

import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ControllerReceitas {

    @Autowired
    private ReceitasService receitasService;


    @PostMapping("receitas")
    public ResponseEntity<ReceitasDTO> create(@RequestBody ReceitasDTO receita){
        ReceitasEntity receitasEntity = receita.toEntity();

        ReceitasEntity receitasEntitySalvo = this.receitasService.create(receitasEntity);

        return ResponseEntity.ok().body(receitasEntitySalvo.toDTO());
    }


    @GetMapping("receitas")
    public ResponseEntity<List<ReceitasDTO>> getAllReceitas() {
        List<ReceitasEntity> lista = this.receitasService.getAllReceitas();

        List<ReceitasDTO> listaDTO = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            listaDTO.add( lista.get(i).toDTO() );
        }

        List<ReceitasDTO> listaDTO2 = lista.stream()
                .map( x -> x.toDTO()).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }

    @PutMapping("receitas/{id}")
    public ResponseEntity<ReceitasDTO> update(@PathVariable int id,
                                              @RequestBody ReceitasDTO receitasDTO){
        ReceitasEntity receitasEntitySalvo = this.receitasService.update(id, receitasDTO.toEntity());
        return ResponseEntity.ok().body(receitasEntitySalvo.toDTO());
    }

    @DeleteMapping("receitas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.receitasService.delete(id);
        return ResponseEntity.ok().build();
    }

    
    @GetMapping("receitas/{descricao}")
    public ResponseEntity<List<ReceitasDTO>> getByDescricaoContains (@PathVariable String descricao){
    	List<ReceitasEntity> lista = this.receitasService.getByDescricaoContains(descricao);
		
		List<ReceitasDTO> listaDTO = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			listaDTO.add( lista.get(i).toDTO() );
		}
				
		return ResponseEntity.ok().body( listaDTO );
    	
    }
}
