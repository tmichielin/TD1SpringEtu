package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"informatique", "info", "computer"})
public class InformatiqueController {

	@GetMapping("clavier")
	public String clavier(Model m)
	{
		
		
		return "clavier";
	}
}
