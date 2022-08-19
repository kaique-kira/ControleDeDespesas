package br.com.kira.ControleDeDespesas.Controller;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class ControllerDespesas {

    @Autowired
    private DespesasService despesasService;


    @GetMapping("despesas")
    public ResponseEntity<List<DespesasDTO>> getAll(){
        List<DespesasEntity> lista = this.despesasService.getAll();
        List<DespesasDTO> listaDto = new ArrayList<>();
        List<DespesasDTO> listaDto2 = lista.stream().map(x -> x.toDTO()).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto2);
    }

    @PostMapping("despesas")
    public ResponseEntity<DespesasDTO> createDespesas (@RequestBody DespesasDTO despesasDTO){
        DespesasEntity despesasEntity = despesasDTO.toEntity();
        DespesasEntity despesasEntitySalvo = this.despesasService.save(despesasEntity);
        return ResponseEntity.ok().body(despesasEntitySalvo.toDTO());
    }

    @PutMapping("despesas/{id}")
    public ResponseEntity <DespesasDTO> update(@PathVariable int id,
                                               @RequestBody DespesasDTO despesasDTO){
        return ResponseEntity.ok().body(
                this.despesasService.update(id, despesasDTO.toEntity()).toDTO());
    }

    @DeleteMapping("despesas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.despesasService.delete(id);

        return ResponseEntity.ok().build();
    }
    
    @GetMapping("despesas/{descricao}")
    public ResponseEntity<List<DespesasDTO>> getByDescricaoContains (@PathVariable String descricao){
    	List<DespesasEntity> lista = this.despesasService.getByDescricaoContains(descricao);
		
		List<DespesasDTO> listaDTO = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			listaDTO.add( lista.get(i).toDTO() );
		}
				
		return ResponseEntity.ok().body( listaDTO );
    	
    }

    @GetMapping("despesas/{ano}/{mes}")
    public ResponseEntity<List<DespesasDTO>> findByMonthFromDespesas(@PathVariable Integer ano, @PathVariable Integer mes) {
    	List<DespesasEntity> lista = this.despesasService.findByMonthFromDespesas(ano, mes);

        List<DespesasDTO> listaDTO = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            listaDTO.add( lista.get(i).toDTO() );
        }

        return ResponseEntity.ok().body(listaDTO);
}


}
