package br.com.kira.ControleDeDespesas.Repository;


import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

@Repository
public interface DespesasRepository extends JpaRepository<DespesasEntity, Integer> {
 
	public List<DespesasEntity> findByDescricaoContains(String descricao);
	
	@Query(value="SELECT * FROM despesas r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes", nativeQuery = true)
	List<DespesasEntity> findByMonthFromDespesas(Integer ano, Integer mes);
	
	@Query(value = "SELECT NEW categoria(d.categoria, SUM(d.valor)) FROM Despesas d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes GROUP BY d.categoria", nativeQuery = true)
	List<DespesasEntity> findTotalAmountByCategoria(Integer ano, Integer mes);
	
	
	@Query(value = "SELECT sum(valor) FROM Despesas where data = month(:mes);", nativeQuery = true)
	List<DespesasEntity> findResumyByMonthIncome(Integer ano, Integer mes);
	
	@Query("SELECT d.categoria AS categoria, SUM(d.valor) AS total FROM Despesa d WHERE d.data >= :startDate AND d.data <= :endDate GROUP BY d.categoria")
	public List<DespesasEntity> countTotalDespesaByCategoryBetweenData(LocalDate startDate, LocalDate endDate);
	
	@Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.data >= :startDate AND d.data <= :endDate")
	public Optional<BigDecimal> sumBetweenData(LocalDate startDate, LocalDate endDate);
}