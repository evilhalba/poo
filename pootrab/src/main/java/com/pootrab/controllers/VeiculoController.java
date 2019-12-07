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

import com.pootrab.models.ModeloVeiculo;
import com.pootrab.models.Veiculo;
import com.pootrab.repository.ModeloVeiculoRepository;
import com.pootrab.repository.VeiculoRepository;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoRepository veir;
	
	@Autowired 
	private ModeloVeiculoRepository modvr;
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.GET)
	public ModelAndView cadastrarVeiculoGET() {
		ModelAndView mv  = new ModelAndView("veiculo/cadastrar");
		Iterable<ModeloVeiculo> modelosveiculos = modvr.findAll();
		mv.addObject("modelosveiculos", modelosveiculos);
		return mv;
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.POST)
	public String cadastrarVeiculoPOST(@Valid Veiculo veiculo,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarVeiculo";
		}else {
			veir.save(veiculo);
			attributes.addFlashAttribute("mensagem", "Veiculo cadastrado com sucesso!");
			return "redirect:/listarVeiculos";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarVeiculos")
	public ModelAndView listarVeiculos() {
		ModelAndView mv = new ModelAndView("veiculo/listar");
		Iterable<Veiculo> veiculos = veir.findAll();		
		mv.addObject("veiculos", veiculos);
		
		return mv;
	}
	
	@RequestMapping("/deletarVeiculo/{id}")
	public String deletarUnidade(@PathVariable("id") int id, RedirectAttributes attributes ) {
		Veiculo veiculo = veir.findById(id);
		veir.delete(veiculo);
		attributes.addFlashAttribute("mensagem" , "Veiculo deletado com sucesso!");
		return "redirect:/listarVeiculos";
	}
}
