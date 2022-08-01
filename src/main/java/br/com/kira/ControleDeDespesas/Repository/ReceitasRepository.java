package br.com.kira.ControleDeDespesas.Repository;


import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<ReceitasEntity, Integer>{
}
