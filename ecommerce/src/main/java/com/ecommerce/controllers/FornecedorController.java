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

import com.ecommerce.models.Fornecedor;
import com.ecommerce.repositories.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("fornecedor/index");
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		model.addObject("fornecedors", listaFornecedor);
		return model;
	}

	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id") Integer idFornecedor) {
		model.addAttribute("idFornecedor", idFornecedor);
		return "fornecedor/edit";
	}

	@GetMapping("/create")
	public String create() {
		return "fornecedor/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("fornecedor") Fornecedor objFornecedor) {
		fornecedorRepository.save(objFornecedor);
		return "redirect:/fornecedor";
	}

}
