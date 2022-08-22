package br.com.kira.ControleDeDespesas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.kira.ControleDeDespesas.DTO.ResumoDTO;
import br.com.kira.ControleDeDespesas.Service.ResumoService;

public class ControllerResumo {
	
	@Autowired
	public ResumoService resumoService;
	

    @GetMapping("/{ano}/{mes}")
    public ResumoDTO resumoDoMes(@PathVariable("ano") Integer ano, @PathVariable("mes") Integer mes) {
        return resumoService.resumoDoMes(ano, mes);
    }
	
}
