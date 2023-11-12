package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Produit;

public class GestionCatalogueImplimentationJPA implements ImplementProduit  {
	//class hadha + persistence
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
	EntityManager em = emf.createEntityManager();
	//class hadha + persistence
	@Override
	public void addProduit(Produit p) {	
		EntityTransaction et = em.getTransaction() ;
		et.begin();
		em.persist(p);
		et.commit();
	}
	@Override
	public List<Produit> getAllProduit() {
		Query q =em.createQuery("select p from Produit p");
		return q.getResultList();
	}
	@Override
	public void DeleteProduit(int id) {
		em.getTransaction().begin();		
		em.remove(getProduit(id));
		em.getTransaction().commit();
	}
	@Override
	public Produit getProduit(int id) {
		// TODO Auto-generated method stub
		return em.find(Produit.class,id);
	}
	@Override
	public void ModifyProduit(Produit p) {
		em.getTransaction().begin();		
		em.merge(p);
		em.getTransaction().commit();
		
	}
	@Override
	public List<Produit> GetProduitByMc(String mc) {
		Query q =em.createQuery("select p from Produit p where p.nom like  ");
		q.setParameter("x", "%"+mc+"%"); 
		return q.getResultList();
	}

}
