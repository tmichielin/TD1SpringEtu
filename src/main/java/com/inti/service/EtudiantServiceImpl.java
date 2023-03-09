package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Etudiant;
import com.inti.util.HibernateUtil;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Etudiant> getEtudiants() {
		List<Etudiant> listeEtudiants = null;
		
		try
		{
			session.beginTransaction();
			
			listeEtudiants = session.createNativeQuery("select * from etudiant", Etudiant.class).list();
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeEtudiants;
	}

	@Override
	public void saveEtudiant(Etudiant e) {
		try
		{
			session.beginTransaction();
			
			session.save(e);
			
			session.getTransaction().commit();
		}
		catch (Exception exc) {
			exc.printStackTrace();
			session.getTransaction().rollback();
		}

	}

	@Override
	public Etudiant getEtudiant(int id) {
		Etudiant etu = null;
		try
		{
			session.beginTransaction();
			
			etu = session.get(Etudiant.class, id);
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return etu;
	}

	@Override
	public void deleteEtudiant(int id) {
		try
		{
			session.beginTransaction();
			
			session.delete(session.get(Etudiant.class, id));
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}

}
