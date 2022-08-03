package br.com.kira.ControleDeDespesas.Controller;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import br.com.kira.ControleDeDespesas.DTO.ReceitasDTO;
import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ControllerDespesas {

    @Autowired
    private DespesasService despesasService;

    @PostMapping("despesas")
    public ResponseEntity<DespesasDTO> create (@RequestBody DespesasDTO despesas){
        DespesasEntity despesasEntity = new DespesasEntity();

        DespesasEntity despesasEntitySalvo =this.despesasService.create(despesasEntity);

        return ResponseEntity.ok().body(despesasEntitySalvo.toDTO());

    }

    @GetMapping("despesas")
    public ResponseEntity<List<DespesasDTO>> getAll(){
        List<DespesasEntity> lista = this.despesasService.getAll();
        List<DespesasDTO> listaDTO = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaDTO.add( lista.get(i).toDTO() );
        }

        List<DespesasDTO> listaDTO2 = lista.stream()
                .map( x -> x.toDTO()).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }

    @PutMapping("despesas/{id}")
    public ResponseEntity<DespesasDTO> update(@PathVariable int id,
                                              @RequestBody DespesasDTO despesasDTO) {
        DespesasEntity despesasEntitySalvo = this.despesasService.update(id, despesasDTO.toEntity());
        return ResponseEntity.ok().body(despesasEntitySalvo.toDTO());
    }

    @DeleteMapping("despesas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.despesasService.delete(id);
        return ResponseEntity.ok().build();
    }


}
