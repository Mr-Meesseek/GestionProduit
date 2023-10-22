package DAO;
import java.util.List; 
import entities.Produit; 

public interface ImplementProduit {
	public void addProduit(Produit p) ;
	public List <Produit> getAllProduit() ; 
	public void DeleteProduit (int id) ; 
	public Produit getProduit (int id ) ; 
	public void ModifyProduit (Produit p ) ; 
	public List <Produit> GetProduitByMc(String mc)
;
	}
