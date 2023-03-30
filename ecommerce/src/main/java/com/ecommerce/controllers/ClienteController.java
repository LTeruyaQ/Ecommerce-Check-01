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

import com.ecommerce.models.Cliente;
import com.ecommerce.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/index");
		List<Cliente> listaCliente = clienteRepository.findAll();
		model.addObject("clientes", listaCliente);
		return model;
	}

	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id") Integer idCliente) {
		model.addAttribute("idCliente", idCliente);
		return "cliente/edit";
	}

	@GetMapping("/create")
	public String create() {
		return "cliente/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("cliente") Cliente objCliente) {
		clienteRepository.save(objCliente);
		return "redirect:/cliente";
	}

}
