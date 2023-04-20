package com.juliechan.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juliechan.dojosninjas.models.Dojo;
import com.juliechan.dojosninjas.models.Ninja;
import com.juliechan.dojosninjas.services.DojoService;
import com.juliechan.dojosninjas.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class NinjaController {
	// CONNECTING NINJA SERVICE
	@Autowired
	private NinjaService nService;
	
	// CONNECTING DOJO SERVICE
	@Autowired
	private DojoService dService;
	
	// RENDER CREATE NEW NINJA FORM
	@GetMapping("/ninjas")
	public String rNinjaPage(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> schools = dService.getAll();
		model.addAttribute("dojos", schools);
		return "new_ninja.jsp";
	}
	
	// NINJA FORM
	@PostMapping("/ninjas/new")
	public String pCreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> schools = dService.getAll();
			model.addAttribute("dojos", schools);
			System.out.println("schools");
			return "new_ninja.jsp";
		}
		nService.createOrUpdate(ninja);
		return "redirect:/dojos";
	}

}
