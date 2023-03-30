
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

import com.ecommerce.models.Produto;
import com.ecommerce.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
		List<Produto> listaProduto = produtoRepository.findAll();
		model.addObject("produtos", listaProduto);
		return model;
	}

	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id") Integer idProduto) {
		model.addAttribute("idProduto", idProduto);
		return "produto/edit";
	}

	@GetMapping("/create")
	public String create() {
		return "produto/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("produto") Produto objProduto) {
		produtoRepository.save(objProduto);
		return "redirect:/produto";
	}

}
