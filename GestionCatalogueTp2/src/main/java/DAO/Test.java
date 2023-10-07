package DAO;
import entities.Produit;
import java.util.*;
public class Test {
	public static void main (String[] x)
	{
		Produit p= new Produit(1,"tlf",0,12);
		Produit pp= new Produit(2,"tlf",0,12);
		Produit ppp= new Produit(3,"tlf",0,12);
		GestionProduit g = new GestionProduit();
		p.setName("hh");
		g.ModifyProduit(p);
		List<Produit> liste = new ArrayList<>();
		liste=g.getAllProduit();
		System.out.println(g.GetProduitByMc("tlf").toString());
		System.out.println(liste.toString());
		
		 
	}
}
