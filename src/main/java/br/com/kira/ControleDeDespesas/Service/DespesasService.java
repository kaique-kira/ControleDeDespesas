package br.com.kira.ControleDeDespesas.Service;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Exception.ObjNotFoundException;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;

    public DespesasEntity create(DespesasEntity receita) {
        DespesasEntity novaDespesa = new DespesasEntity();

        novaDespesa.setDescricao(receita.getDescricao());
        novaDespesa.setValor(receita.getValor());
        novaDespesa.setData(receita.getData());

        System.out.println(novaDespesa);

        novaDespesa = (DespesasEntity) this.despesasRepository.save(novaDespesa);

        return novaDespesa;
    }

    public List<DespesasEntity> getAll() {
        List<DespesasEntity> despesa = this.despesasRepository.findAll();
        return despesa;
    }

    public DespesasEntity update(int id, DespesasEntity despesasEntity) {
        Optional<DespesasEntity> receitasEntityOptional = this.despesasRepository.findById(id);
        if (receitasEntityOptional.isPresent()) {
            DespesasEntity despesasUpdate = receitasEntityOptional.get();
            despesasUpdate.setDescricao(despesasEntity.getDescricao());
            despesasUpdate.setValor(despesasEntity.getValor());
            despesasUpdate.setData(despesasEntity.getData());

            return (DespesasEntity) this.despesasRepository.save(despesasUpdate);
        } else {
            return null;
        }
    }

    public void delete(int id ){
        this.despesasRepository.deleteById(id);
    }


}
