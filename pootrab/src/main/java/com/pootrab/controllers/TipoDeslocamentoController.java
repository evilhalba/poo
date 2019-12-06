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
import com.pootrab.repository.TipoDeslocamentoRepository;

@Controller
public class TipoDeslocamentoController {
	
	
	@Autowired
	private TipoDeslocamentoRepository tdr;
	
	@RequestMapping(value="/cadastrarTipoDeslocamento", method=RequestMethod.GET)
	public String cadastrarTipoDeslocamentoGET() {
		
		return "tipodeslocamento/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarTipoDeslocamento", method=RequestMethod.POST)
	public String cadastrarTipoDeslocamentoPOST(@Valid TipoDeslocamento tipodeslocamento,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarTipoDeslocamento";
		}else {
			tdr.save(tipodeslocamento);
			attributes.addFlashAttribute("mensagem", "Tipo de Deslocamento cadastrada com sucesso!");
			return "redirect:/listarTiposDeslocamentos";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarTiposDeslocamentos")
	public ModelAndView listarTiposDeslocamentos() {
		ModelAndView mv = new ModelAndView("tipodeslocamento/listar");
		Iterable<TipoDeslocamento> tiposdeslocamentos = tdr.findAll();		
		mv.addObject("tiposdeslocamentos ", tiposdeslocamentos);
		
		return mv;
	}
	
	@RequestMapping("/deletarTipoDeslocamento/{tipodeslocamentoid}")
	public String deletarSituacao(@PathVariable("tipodeslocamentoid") String tipodeslocamentoid, RedirectAttributes attributes ) {
		TipoDeslocamento tipoDeslocamento = tdr.findByTipodeslocamentoid(tipodeslocamentoid);
		tdr.delete(tipoDeslocamento);
		attributes.addFlashAttribute("mensagem" , "Tipo de Deslocamento deletado com sucesso!");
		return "redirect:/listarTiposDeslocamentos";
	}
}
