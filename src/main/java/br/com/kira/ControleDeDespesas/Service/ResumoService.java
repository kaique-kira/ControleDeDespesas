package br.com.kira.ControleDeDespesas.Service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;

public class ResumoService {
	
	@Autowired
	private DespesasRepository despesasRepository;
	
	@Autowired
	private ReceitasRepository receitasRepository;
	
	

}
