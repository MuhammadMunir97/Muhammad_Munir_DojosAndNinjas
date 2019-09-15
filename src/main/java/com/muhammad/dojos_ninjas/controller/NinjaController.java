package com.muhammad.dojos_ninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muhammad.dojos_ninjas.modell.Ninja;
import com.muhammad.dojos_ninjas.service.NinjaService;

@Controller
public class NinjaController {

	private final NinjaService ninjaService;

	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninja")
	public String showAllNinjas(Model model) {
		List<Ninja> allNinja = ninjaService.findAll();
		model.addAttribute("ninjas" , allNinja);
		return "/view/Ninja.jsp";
	}
	
	@RequestMapping("/ninja/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja) {
		return "/view/NewNinja.jsp";
	}
	
	@RequestMapping(value="/ninja" , method=RequestMethod.POST)
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/ninja";
		}else {
			ninjaService.saveNinja(ninja);
			return "redirect:/ninja";
		}
	}
	
	@RequestMapping(value="/ninja/{id}" , method=RequestMethod.DELETE)
	public String deleteNinja(@PathVariable("id") Long id) {
		ninjaService.deleteNinjaById(id);
		return "redirect:/ninja";
	}
}
