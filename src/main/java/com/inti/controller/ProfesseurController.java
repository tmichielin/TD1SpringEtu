package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Etudiant;
import com.inti.model.Professeur;
import com.inti.service.ProfesseurService;

@Controller
@RequestMapping("professeur")
public class ProfesseurController {

	@Autowired
	ProfesseurService ps;
	
	@GetMapping("save")
	public String enregistrerProfesseur(@RequestParam("nom") String nom, 
			@RequestParam("prenom") String prenom, @RequestParam("tel") String tel,
			@RequestParam("mail") String mail, Model m)
	{
		Professeur p = new Professeur(nom, prenom, tel, mail);
		
		ps.saveProfesseur(p);
		
		m.addAttribute("p", p);
		
		return "enregistrerProfesseur";
	}
	
	@GetMapping("listerProfesseurs")
	public String getAllProfesseur(Model m)
	{
		m.addAttribute("listeP", ps.getProfesseurs());
		
		return "listerE";
	}

	@GetMapping("supprimer")
	public String deleteProfesseur(@RequestParam("id") int id, Model m)
	{
		ps.deleteProfesseur(id);
		
		return "deleteP";
	}
	
	@GetMapping("inscriptionP")
	public String inscriptionProfesseur()
	{
		return "inscriptionP";
	}
	
	@PostMapping("saveProfAvecForm")
	public String enregistrerProf(@ModelAttribute("prof") Professeur p, Model m)
	{
		ps.saveProfesseur(p);
		
		m.addAttribute("p", p);
		
//		return "enregistrer";
//		return "inscription";
		return "redirect:/professeur/inscriptionP";
	}
}
