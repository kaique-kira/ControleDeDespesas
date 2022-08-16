package br.com.kira.ControleDeDespesas.Repository;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DespesasRepository extends JpaRepository<DespesasEntity, Integer> {

    @Query(value = "SELECT * FROM DESPESAS WHERE categoria LIKE %:categoria%")
    List<DespesasEntity> searchByCategoria(@Param("categoria") String categoria);

}
