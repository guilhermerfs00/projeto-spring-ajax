package com.projeto.demoprojeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.demoprojeto.domain.Categoria;
import com.projeto.demoprojeto.repository.CategoriaRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategoria(){
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/add")
	static String abrirCadastro() {
		return "promo-add";
	}
}