package br.com.kira.ControleDeDespesas.Repository;


import br.com.kira.ControleDeDespesas.Entity.ReceitasEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<ReceitasEntity, Integer>{

	public List<ReceitasEntity> findByDescricaoContains(String descricao);
	
	@Query(value="SELECT * FROM Receitas r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes", nativeQuery = true)
	List<ReceitasEntity> findByMonth(Integer ano, Integer mes);
	
	@Query(value = "SELECT sum(valor) FROM Receitas where data  = month(:mes);", nativeQuery = true)
	double findSumReceita(Integer ano, Integer mes);


}
