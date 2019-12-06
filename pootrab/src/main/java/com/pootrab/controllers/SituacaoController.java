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


import com.pootrab.models.Situacao;
import com.pootrab.repository.SituacaoRepository;

@Controller
public class SituacaoController {

	
	@Autowired
	private SituacaoRepository sr;
	
	
	@RequestMapping(value="/cadastrarSituacao", method=RequestMethod.GET)
	public String cadastrarSituacaoGET() {
		
		return "situacao/cadastrar";
	}
	
	@RequestMapping(value="/cadastrarSituacao", method=RequestMethod.POST)
	public String cadastrarSituacaoPOST(@Valid Situacao situacao,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarSituacao";
		}else {
			sr.save(situacao);
			attributes.addFlashAttribute("mensagem", "Situacao cadastrada com sucesso!");
			return "redirect:/listarSituacoes";
		}
		
	}
	
	
	
	@RequestMapping(value="/listarSituacoes")
	public ModelAndView listarSituacoes() {
		ModelAndView mv = new ModelAndView("situacoes/listar");
		Iterable<Situacao> situacoes = sr.findAll();		
		mv.addObject("situacoes", situacoes);
		
		return mv;
	}
	
	@RequestMapping("/deletarSituacao/{situacaoid}")
	public String deletarSituacao(@PathVariable("situacaoid") String situacaoid, RedirectAttributes attributes ) {
		Situacao situacao = sr.findBySituacaoid(situacaoid);
		sr.delete(situacao);
		attributes.addFlashAttribute("mensagem" , "Situação deletada com sucesso!");
		return "redirect:/listarSituacoes";
	}
}
