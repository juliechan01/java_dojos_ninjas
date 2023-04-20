package com.juliechan.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juliechan.dojosninjas.models.Dojo;
import com.juliechan.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	// CONNECTING DOJO SERVICE
	@Autowired
	private DojoService dService;
	
	// ALL DOJOS PAGE
	@GetMapping("")
	public String rHome(Model model, @ModelAttribute("dojo") Dojo dojo) { // RENDERS DATA BINDING FORM
		List<Dojo> school = dService.getAll();
		model.addAttribute("dojos", school); // RENDERS ALL DOJOS TABLE
		System.out.println(dojo);
		return "home.jsp";
	}
	
	// NEW DOJO FORM - CREATE A DOJO
	@PostMapping("/new")
	public String pCreateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dService.getAll());
			return "home.jsp";
		}
		dService.createOrUpdate(dojo);
		return "redirect:/dojos";
	}
	
	// READ ONE DOJO AND ALL NINJAS IN DOJO
	@GetMapping("/{id}")
	public String rSeeDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dService.getOne(id);
		model.addAttribute("dojo", dojo);
		return "one_dojo.jsp";
	}

}
