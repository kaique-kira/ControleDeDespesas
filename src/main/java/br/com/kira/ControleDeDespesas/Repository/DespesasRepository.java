package br.com.kira.ControleDeDespesas.Repository;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<DespesasEntity, Integer> {
 
	public List<DespesasEntity> findByDescricaoContains(String descricao);
	
	@Query(value="SELECT * FROM despesas r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes", nativeQuery = true)
	List<DespesasEntity> findByMonthFromDespesas(Integer ano, Integer mes);
}
