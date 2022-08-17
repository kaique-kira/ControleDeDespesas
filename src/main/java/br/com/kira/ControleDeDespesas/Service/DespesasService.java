package br.com.kira.ControleDeDespesas.Service;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;

    public List<DespesasEntity> getAll(){
        return this.despesasRepository.findAll();
    }

    public DespesasEntity save(DespesasEntity despesas) {
        return this.despesasRepository.save(despesas);
    }

    public DespesasEntity createDespesas(DespesasEntity despesas){
        DespesasEntity novaDespesas= new DespesasEntity();

        novaDespesas.setDescricao(despesas.getDescricao());
        novaDespesas.setValor(despesas.getValor());
        novaDespesas.setData(despesas.getData());
        novaDespesas.setCategoria(despesas.getCategoria());

        System.out.println(novaDespesas);

        novaDespesas = this.despesasRepository.save(novaDespesas);

        return novaDespesas;
    }

    public DespesasEntity update(int id, DespesasEntity despesas) {
        Optional<DespesasEntity> despesasEntity = this.despesasRepository.findById(id);
        if(despesasEntity.isPresent()) {
            DespesasEntity despesasUpdate = despesasEntity.get();

            despesasUpdate.setDescricao(despesas.getDescricao());
            despesasUpdate.setData(despesas.getData());
            despesasUpdate.setValor(despesas.getValor());
            despesasUpdate.setCategoria(despesas.getCategoria());
            return this.despesasRepository.save(despesasUpdate);
        } else {
            return null;
        }
    }

    public void delete(int id) {
        try {
            this.despesasRepository.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("Erro ao deletar o registro");
        }
    }
    
    public List<DespesasEntity> getByDescricaoContains(String descricao){
    	return this.despesasRepository.findByDescricaoContains(descricao);
    }

}
