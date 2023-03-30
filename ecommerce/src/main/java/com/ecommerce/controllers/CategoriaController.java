package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.models.Categoria;
import com.ecommerce.repositories.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("categoria/index");
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		model.addObject("categorias", listaCategoria);
		return model;
	}

	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id") Integer idCategoria) {
		model.addAttribute("idCategoria", idCategoria);
		return "categoria/edit";
	}

	@GetMapping("/create")
	public String create() {
		return "categoria/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("categoria") Categoria objCategoria) {
		categoriaRepository.save(objCategoria);
		return "redirect:/categoria";
	}

}
