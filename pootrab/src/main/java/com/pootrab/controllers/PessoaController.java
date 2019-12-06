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

import com.pootrab.models.Pessoa;
import com.pootrab.repository.PessoaRepository;

@Controller
public class PessoaController {
	@Autowired
	private PessoaRepository pr;
	
	@RequestMapping(value="/cadastrarPessoa", method=RequestMethod.GET)
	public ModelAndView cadastrarPessoaGET() {
		ModelAndView mv = new ModelAndView("pessoa/cadastrar");
		return mv;
	}
	
	
	@RequestMapping(value="/cadastrarPessoa", method=RequestMethod.POST)
	public String cadastrarPessoaPOST(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			return "redirect:/cadastrarPessoa";
		}else {
			pr.save(pessoa);
			attributes.addFlashAttribute("mensagem", "Pessoa cadastrada com sucesso!");
			return "redirect:/listarPessoas";
		}
		
	}
	
	@RequestMapping(value="/listarPessoas")
	public ModelAndView listarPessoas() {
		ModelAndView mv = new ModelAndView("pessoa/listar");
		Iterable<Pessoa> pessoas = pr.findAll();		
		mv.addObject("pessoas", pessoas);
		
		return mv;
	}
	
	@RequestMapping("/deletarPessoa/{idPessoa}")
	public String deletarPessoa(@PathVariable("idPessoa") int idPessoa, RedirectAttributes attributes) {
		Pessoa pessoa = pr.findByIdPessoa(idPessoa);
		pr.delete(pessoa);
		
		attributes.addFlashAttribute("mensagem" , "Pessoa deletada com sucesso!");
		return "redirect:/listarPessoas";
		
	}
	
	
	@RequestMapping(value="/detalhesPessoa/{idPessoa}", method=RequestMethod.GET)
	public ModelAndView deltalhesPessoaGET(@PathVariable("idPessoa") int idPessoa){
		ModelAndView mv = new ModelAndView("pessoa/detalhes");
		Pessoa pessoa = pr.findByIdPessoa(idPessoa);
		mv.addObject("pessoa", pessoa);
		
		return mv;
	}
	
	@RequestMapping(value="/detalhesPessoa/{idPessoa}", method=RequestMethod.POST)
	public ModelAndView deltalhesPessoaPOST(@PathVariable("idPessoa") int idPessoa ,@Valid Pessoa pessoa,BindingResult result, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Dados incorretos ou incompletos, favor revisar!");
			mv.setViewName("redirect:/detalhesPessoa/"+idPessoa);
			return mv;
		}else {
			pessoa.setIdPessoa(idPessoa);
			pr.save(pessoa);
			
			attributes.addFlashAttribute("mensagem", "Alterações salvas!");
			mv.setViewName("redirect:/detalhesPessoa/"+idPessoa);
			return mv;
		}
		
		
	}
	
	
}
