package br.com.kira.ControleDeDespesas.Controller;

<<<<<<< Updated upstream
public class ControllerResumo {
	
=======
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import br.com.kira.ControleDeDespesas.Repository.DespesasRepository;
import br.com.kira.ControleDeDespesas.Repository.ReceitasRepository;


public class ControllerResumo {
	
	@Autowired
	private ReceitasRepository receitaRepository;
	@Autowired
	private DespesasRepository despesaRepository;

	
	@GetMapping("resumo/{ano}/{mes}")
	public ResponseEntity<?> summaryByMonth(@PathVariable Integer ano, @PathVariable Integer mes) {
		
		LocalDate startDate;
		
		try {
			startDate = LocalDate.of(ano, mes, 1);
		} catch (DateTimeException e) {
			return ResponseEntity
					.badRequest()
					.build();
		}
		
		LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

		ResumoDTO resumoDto = new ResumoDTO();
		
		return ResponseEntity.ok(resumoDto);
	}
>>>>>>> Stashed changes
	
}
