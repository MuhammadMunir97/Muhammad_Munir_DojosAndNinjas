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

import com.muhammad.dojos_ninjas.modell.Dojo;
import com.muhammad.dojos_ninjas.modell.Ninja;
import com.muhammad.dojos_ninjas.service.DojoService;

@Controller
public class DojoController {

	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojo")
	public String showAllDojos(Model model) {
		List<Dojo> allDojos = dojoService.findAll();
		model.addAttribute("dojos", allDojos);
		return "/view/Dojo.jsp";
	}
	
	@RequestMapping("/dojo/new")
	public String addDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/view/NewDojo.jsp";
	}
	
	@RequestMapping("/dojo/ninja/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.findAll();
		model.addAttribute("dojos", allDojos);
		return "/view/NewNinja.jsp";
	}
	
	@RequestMapping("dojo/{id}")
	public String showDojoStudents(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findById(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas" , ninjas);
		return "/view/Ninja.jsp";
	}
	
	@RequestMapping(value="/dojo" , method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			 return "redirect:/dojo";
        } else {
        	dojoService.saveDojo(dojo);
            return "redirect:/dojo";
        }
	}
	@RequestMapping(value="/dojo/{id}" , method=RequestMethod.DELETE)
	public String deleteDojo(@PathVariable("id") Long id) {
		dojoService.deleteDojoById(id);
		return "redirect:/dojo";
	}
}
