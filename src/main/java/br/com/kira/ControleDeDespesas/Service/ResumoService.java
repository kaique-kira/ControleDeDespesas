package br.com.kira.ControleDeDespesas.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import br.com.kira.ControleDeDespesas.Entity.DespesasEntity;
import br.com.kira.ControleDeDespesas.Entity.ResumoEntity;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;

public class ResumoService {

	@Autowired
	private ReceitasRepository receitaRepository;

	@Autowired
	private DespesasRepository despesaRepository;



}
