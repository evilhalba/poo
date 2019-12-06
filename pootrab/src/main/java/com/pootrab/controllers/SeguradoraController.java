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
import com.pootrab.models.Seguradora;
import com.pootrab.repository.SeguradoraRepository;

@Controller
public class SeguradoraController {

	
	@Autowired
	private SeguradoraRepository sr;
	
	@RequestMapping(value="/cadastrarSeguradora", method=RequestMethod.GET)
	public String cadastrarSeguradoraGET() {
		
		return "seguradora/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarSeguradora", method=RequestMethod.POST)
	public String cadastrarSeguradoraPOST(@Valid Seguradora seguradora,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarSeguradora";
		}else {
			sr.save(seguradora);
			attributes.addFlashAttribute("mensagem", "Seguradora cadastrada com sucesso!");
			return "redirect:/listarSeguradoras";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarSeguradoras")
	public ModelAndView listarSeguradoras() {
		ModelAndView mv = new ModelAndView("seguradora/listar");
		Iterable<Seguradora> seguradoras = sr.findAll();		
		mv.addObject("seguradoras", seguradoras);
		
		return mv;
	}
	
	@RequestMapping("/deletarSeguradora/{id}")
	public String deletarSeguradora(@PathVariable("id") int id, RedirectAttributes attributes ) {
		Seguradora seguradora = sr.findById(id);
		sr.delete(seguradora);
		attributes.addFlashAttribute("mensagem" , "Seguradora deletada com sucesso!");
		return "redirect:/listarSeguradoras";
	}
}
