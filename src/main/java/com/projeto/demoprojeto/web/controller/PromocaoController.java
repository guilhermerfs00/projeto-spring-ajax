package com.projeto.demoprojeto.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.demoprojeto.domain.Categoria;
import com.projeto.demoprojeto.domain.Promocoes;
import com.projeto.demoprojeto.repository.CategoriaRepository;
import com.projeto.demoprojeto.repository.PromocaoRepository;



@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	
    @Autowired
    private PromocaoRepository promocaoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping("/save")
	public ResponseEntity<?> salvarPromocao(@Valid Promocoes promocao, BindingResult result) {
		if (result.hasErrors()) {
					
					Map<String, String> errors = new HashMap<>();
					for (FieldError error : result.getFieldErrors()) {
						errors.put(error.getField(), error.getDefaultMessage());
					}
					
					return ResponseEntity.unprocessableEntity().body(errors);
				}
		promocao.setDtCadastro(LocalDateTime.now());
		promocaoRepository.save(promocao);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list")
	public String listarOfertas(ModelMap model) {
		Sort sort = new Sort(Sort.Direction.DESC, "dtCadastro");
		model.addAttribute("promocoes", promocaoRepository.findAll(sort));
		return "promo-list";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		
		return categoriaRepository.findAll(); 
	}

	@GetMapping("/add")
	public String abrirCadastro() {
		
		return "promo-add";
	}
}