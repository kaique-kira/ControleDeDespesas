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
	
	@Query(value = "SELECT NEW categoria(d.categoria, SUM(d.valor)) FROM Despesas d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes GROUP BY d.categoria", nativeQuery = true)
	List<DespesasEntity> findTotalAmountByCategoria(Integer ano, Integer mes);
	
	
	@Query(value = "SELECT sum(valor) FROM Despesas where data = month(:mes);", nativeQuery = true)
	List<DespesasEntity> findResumyByMonthIncome(Integer ano, Integer mes);
	
}