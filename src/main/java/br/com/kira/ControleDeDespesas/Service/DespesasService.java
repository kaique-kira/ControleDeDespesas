package br.com.kira.ControleDeDespesas.Service;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;

    public List<DespesasEntity> getAll(){
        return this.despesasRepository.findAll();
    }

    public DespesasEntity getByCategoria(String categoria) {
        return (DespesasEntity) this.despesasRepository.searchByCategoria(categoria);
    }

    public DespesasEntity save(DespesasEntity despesas) {
        return this.despesasRepository.save(despesas);
    }

    public DespesasEntity create(DespesasEntity despesas){
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

        DespesasEntity despesasUpdate = this.despesasRepository.findById(id).orElseThrow();

        despesasUpdate.setDescricao( despesas.getDescricao() );
        despesasUpdate.setData( despesas.getData() );
        despesasUpdate.setValor( despesas.getValor() );
        despesasUpdate.setCategoria(despesas.getCategoria() );

        return (DespesasEntity) this.despesasRepository.save(despesasUpdate);
    }

    public void delete(int id) {
        try {
            this.despesasRepository.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("Erro ao deletar o registro");
        }

    }

}
