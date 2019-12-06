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

import com.pootrab.models.TipoDeslocamento;
import com.pootrab.models.Unidade;
import com.pootrab.repository.UnidadeRepository;

@Controller
public class UnidadeController {

	@Autowired
	private UnidadeRepository ur;
	
	
	
	@RequestMapping(value="/cadastrarUnidade", method=RequestMethod.GET)
	public String cadastrarUnidadeGET() {
		
		return "unidade/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarUnidade", method=RequestMethod.POST)
	public String cadastrarUnidadePOST(@Valid Unidade unidade,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarUnidade";
		}else {
			ur.save(unidade);
			attributes.addFlashAttribute("mensagem", "Unidade cadastrada com sucesso!");
			return "redirect:/listarUnidades";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarUnidades")
	public ModelAndView listarUnidades() {
		ModelAndView mv = new ModelAndView("unidade/listar");
		Iterable<Unidade> unidades = ur.findAll();		
		mv.addObject("unidades", unidades);
		
		return mv;
	}
	
	@RequestMapping("/deletarUnidade/{id}")
	public String deletarUnidade(@PathVariable("id") int id, RedirectAttributes attributes ) {
		Unidade unidade = ur.findById(id);
		ur.delete(unidade);
		attributes.addFlashAttribute("mensagem" , "Unidade deletada com sucesso!");
		return "redirect:/listarUnidades";
	}
}
