package DAO;

import java.util.List;
import entities.Categorie; 
public interface IGestionCategorie {
public void AddCategorie(Categorie c); 
public List<Categorie> getAllCategories(); 
public Categorie GetCategorie(int id ); 
public void DeleteCategorie(int id) ; 
}
