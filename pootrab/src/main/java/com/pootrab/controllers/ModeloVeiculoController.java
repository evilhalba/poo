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
import com.pootrab.models.ModeloVeiculo;
import com.pootrab.repository.MarcaVeiculoRepository;
import com.pootrab.repository.ModeloVeiculoRepository;

@Controller
public class ModeloVeiculoController {

	@Autowired
	private ModeloVeiculoRepository mvr;
	
	
	
	@RequestMapping(value="/cadastrarModeloVeiculo", method=RequestMethod.GET)
	public String cadastrarModeloVeiculoGET() {
		
		return "modeloveiculo/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarModeloVeiculo", method=RequestMethod.POST)
	public String cadastrarModeloVeiculoPOST(@Valid ModeloVeiculo modeloveiculo,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarModeloVeiculo";
		}else {
			mvr.save(modeloveiculo);
			attributes.addFlashAttribute("mensagem", "Modelo de Veiculo cadastrada com sucesso!");
			return "redirect:/listarModelosVeiculos";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarModelosVeiculos")
	public ModelAndView listarModeloVeiculo() {
		ModelAndView mv = new ModelAndView("modeloveiculo/listar");
		Iterable<ModeloVeiculo> modelosveiculo = mvr.findAll();		
		mv.addObject("modelosveiculo", modelosveiculo);
		
		return mv;
	}
	
	@RequestMapping("/deletarModeloVeiculo/{modeloveiculoid}")
	public String deletarModeloVeiculo(@PathVariable("modeloveiculoid") String modeloveiculoid, RedirectAttributes attributes ) {
		ModeloVeiculo modeloVeiculo = mvr.findByModeloveiculoid(modeloveiculoid);
		mvr.delete(modeloVeiculo);
		attributes.addFlashAttribute("mensagem" , "Modelo de Veiculo deletada com sucesso!");
		return "redirect:/listaModelosVeiculos";
	}
}
