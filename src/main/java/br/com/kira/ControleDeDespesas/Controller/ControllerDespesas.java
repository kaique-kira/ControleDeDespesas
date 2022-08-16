package br.com.kira.ControleDeDespesas.Controller;

import br.com.kira.ControleDeDespesas.DTO.DespesasDTO;
import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ControllerDespesas {

    @Autowired
    private DespesasService despesasService;

    @Autowired
    private DespesasEntity D;

    @GetMapping("despesas")
    public ResponseEntity<List<DespesasDTO>> getAll(){
        List<DespesasEntity> lista = this.despesasService.getAll();
        List<DespesasDTO> listaDto = new ArrayList<>();
        List<DespesasDTO> listaDto2 = lista.stream().map(x -> x.toDTO()).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDto2);
    }

    @PostMapping("despesas")
    public ResponseEntity<DespesasDTO> create (@RequestBody DespesasDTO despesasDTO){
        return ResponseEntity.ok().body(
                this.despesasService.save(despesasDTO.toEntity()).toDTO());

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

    @GetMapping("despesas/get-by-category/{categoria}")
    public ResponseEntity<DespesasDTO> getByCategoria(@PathVariable String categoria){

        return ResponseEntity.ok().body(this.despesasService.getByCategoria(categoria).toDTO());

    }

}
