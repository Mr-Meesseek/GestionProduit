package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Categorie;


public class ImpGestionCategorie implements IGestionCategorie{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
	EntityManager em = emf.createEntityManager();
	@Override
	public void AddCategorie(Categorie c) {
		EntityTransaction et = em.getTransaction() ;
		et.begin();
		em.persist(c);
		et.commit();
		
	}

	@Override
	public List<Categorie> getAllCategories() {
		Query q =em.createQuery("select c from Categorie c");
		return q.getResultList();
	}

	@Override
	public Categorie GetCategorie(int id) {
		return em.find(Categorie.class,id);
		
	}

	@Override
	public void DeleteCategorie(int id) {
		em.getTransaction().begin();		
		em.remove(GetCategorie(id));
		em.getTransaction().commit();
		
	}
	

}
