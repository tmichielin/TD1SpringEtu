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
import com.inti.service.EtudiantService;
import com.inti.service.EtudiantServiceImpl;

@Controller
@RequestMapping("etudiant")
public class EtudiantController {
	
	// Injection de dépendance
	@Autowired
	EtudiantService es;
	
	@GetMapping("save")
	public String enregistrerEtudiant(@RequestParam("nom") String nom, 
			@RequestParam("prenom") String prenom, @RequestParam("tel") String tel,
			@RequestParam("mail") String mail, Model m)
	{
		Etudiant e = new Etudiant(nom, prenom, tel, mail);
		
//		EtudiantService es = new EtudiantServiceImpl();
		es.saveEtudiant(e);
		
		m.addAttribute("e", e);
		
		return "enregistrerEtudiant";
	}
	
	@GetMapping("listerEtudiants")
	public String getAllEtudiant(Model m)
	{
//		EtudiantService es = new EtudiantServiceImpl();
		m.addAttribute("listeE", es.getEtudiants());
		
		return "listerE";
	}
	
	@GetMapping("unEtu")
	public String getEtudiant(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("e", es.getEtudiant(id));
		
		return "etudiant";
	}
	
	@GetMapping("supprimer")
	public String deleteEtudiant(@RequestParam("id") int id, Model m)
	{
		es.deleteEtudiant(id);
		
		return "deleteE";
	}
	
	@GetMapping("inscriptionE")
	public String inscriptionEtudiant()
	{
		return "inscriptionE";
	}
	
	@PostMapping("saveEtuAvecForm")
	public String enregistrerEtu(@ModelAttribute("etu") Etudiant e, Model m)
	{
		es.saveEtudiant(e);
		
		m.addAttribute("e", e);
		
//		return "enregistrer";
//		return "inscription";
		return "redirect:/etudiant/inscriptionE";
	}

}
