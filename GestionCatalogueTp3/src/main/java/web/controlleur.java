package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GestionCatalogueImplimentationJPA;
import DAO.GestionProduit;
import DAO.IGestionCategorie;
import DAO.ImpGestionCategorie;
import DAO.ImplementProduit;
import entities.Categorie;
import entities.Produit;

/**
 * Servlet implementation class controlleur
 */
@WebServlet("/controlleur")
public class controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlleur() {
        super();
        
    }
    ImplementProduit gestion ;
    IGestionCategorie gestCat ;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	  
		gestion= new GestionCatalogueImplimentationJPA() ; 
		gestCat = new ImpGestionCategorie() ; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// get all proucts 
			        if (action == null) {
			            List<Produit> liste = gestion.getAllProduit();
			            request.setAttribute("products", liste);
			            request.getRequestDispatcher("index2.jsp").forward(request, response);
			        } //get product by mot cle 
        else if (action.equalsIgnoreCase("modifierprod")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantities = Integer.parseInt(request.getParameter("quantities"));
            request.setAttribute("categorie",gestCat.getAllCategories());
            request.setAttribute("name", name);
            request.setAttribute("prix", prix);
            request.setAttribute("quantities", quantities);
            request.setAttribute("id", id);
            request.getRequestDispatcher("index3.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("ajouterprod")) {
        	
        
        	request.setAttribute("categorie",gestCat.getAllCategories());
            request.getRequestDispatcher("ajout.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("rechercher")) {
            String mc = request.getParameter("mc");
            request.setAttribute("products", gestion.GetProduitByMc(mc));
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("supprimer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            gestion.DeleteProduit(id);
            request.setAttribute("products", gestion.getAllProduit());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("ajout")) {
            Produit produit = new Produit();
            
            produit.setName(request.getParameter("name"));
            produit.setPrix(Double.parseDouble(request.getParameter("prix")));
            produit.setQuantite(Integer.parseInt(request.getParameter("quantities")));
            produit.setCategorie(gestCat.GetCategorie(Integer.parseInt(request.getParameter("categorie"))));
            gestion.addProduit(produit);
            request.setAttribute("products", gestion.getAllProduit());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("modifier")) {
        	
        	
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int quantities = Integer.parseInt(request.getParameter("quantities"));
            double prix = Double.parseDouble(request.getParameter("prix"));
           Categorie categorie =gestCat.GetCategorie(Integer.parseInt(request.getParameter("categorie")));
            Produit produit = new Produit(id, name, prix, quantities,categorie);
            gestion.ModifyProduit(produit) ;
            request.setAttribute("products", gestion.getAllProduit());
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


