package com.pootrab.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pootrab.models.MarcaVeiculo;
import com.pootrab.repository.MarcaVeiculoRepository;

@Controller
public class MarcaVeiculoController {

	@Autowired
	private MarcaVeiculoRepository mvr;
	
	
	
	@RequestMapping(value="/cadastrarMarcaVeiculo", method=RequestMethod.GET)
	public String cadastrarMarcaVeiculoGET() {
		
		return "marcaveiculo/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarMarcaVeiculo", method=RequestMethod.POST)
	public String cadastrarMarcaVeiculoPOST(@Valid MarcaVeiculo marcaveiculo,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarMarcaVeiculo";
		}else {
			mvr.save(marcaveiculo);
			attributes.addFlashAttribute("mensagem", "Marca de Veiculo cadastrada com sucesso!");
			return "redirect:/listarMarcasVeiculos";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarMarcaVeiculos")
	public ModelAndView listarMarcaVeiculos() {
		ModelAndView mv = new ModelAndView("marcaveiculo/listar");
		Iterable<MarcaVeiculo> marcasveiculos = mvr.findAll();		
		mv.addObject("marcasveiculos", marcasveiculos);
		
		return mv;
	}
	
	@RequestMapping("/deletarMarcaVeiculos/{marcaveiculoid}")
	public String deletarMarcaVeiculo(@PathVariable("marcaveiculoid") String marcaveiculoid, RedirectAttributes attributes ) {
		MarcaVeiculo marcaVeiculo = mvr.findByMarcaveiculoid(marcaveiculoid);
		mvr.delete(marcaVeiculo);
		attributes.addFlashAttribute("mensagem" , "Marca de Veiculo deletada com sucesso!");
		return "redirect:/listarMarcasVeiculos";
	}
	
}
