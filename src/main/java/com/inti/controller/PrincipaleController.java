package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipaleController {
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ModelAndView helloWorld(ModelAndView model)
	{
		model = new ModelAndView("hello");
		return model;		
	}
	
	@GetMapping(value = {"t", "te"})
	public String test(@RequestParam(value="nom", required = false, defaultValue = "Louis") String n, @RequestParam("prenom") String p, Model model)
	{
		System.out.println("Nom : " + n + ", prénom : " + p);
		
		model.addAttribute("name", n);
		
		return "test";
	}

}
