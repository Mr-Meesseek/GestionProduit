package DAO;
import entities.Produit;
public class Test {
	public static void main (String[] x)
	{
		GestionProduit g = new GestionProduit();
		Produit p = new Produit(1,"sdqs",0,5);
		Produit gs=new Produit();
		gs = g.getProduit(1);
		System.out.print(gs.toString());
		
	}
}
