package br.com.kira.ControleDeDespesas.Service;


import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Exception.ObjNotFoundException;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitasService {

    @Autowired
    private ReceitasRepository receitasRepository;

    public ReceitasEntity create(ReceitasEntity receita){
        ReceitasEntity novaReceita = new ReceitasEntity();

        novaReceita.setDescricao(receita.getDescricao());
        novaReceita.setValor(receita.getValor());
        novaReceita.setData(receita.getData());

        System.out.println(novaReceita);

        novaReceita = this.receitasRepository.save(novaReceita);

        return novaReceita;
    }

    public List<ReceitasEntity> getAll(){
        List<ReceitasEntity> receita = this.receitasRepository.findAll();
        return receita;
    }

    public ReceitasEntity getOne(int id){
        return this.receitasRepository.findById(id).orElseThrow(() ->
                new ObjNotFoundException("Elemento com o " + id + "Não encontrado"));
    }
    
    public ReceitasEntity update(int id, ReceitasEntity receitasEntity){
        Optional<ReceitasEntity> receitasEntityOptional = this.receitasRepository.findById(id);
        if (receitasEntityOptional.isPresent()){
            ReceitasEntity receitaUpdate = receitasEntityOptional.get();
            receitaUpdate.setDescricao(receitasEntity.getDescricao());
            receitaUpdate.setValor(receitasEntity.getValor());
            receitaUpdate.setData(receitasEntity.getData());

            return this.receitasRepository.save(receitaUpdate);
        } else {
            return null;
        }
    }

    public void delete(int id ){
        this.receitasRepository.deleteById(id);
    }
}
