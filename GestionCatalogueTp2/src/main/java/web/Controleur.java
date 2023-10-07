package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GestionProduit;
import entities.Produit;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
       
    }
    GestionProduit g;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		g = new GestionProduit();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") ;
		
		if(action==null) {
		List<Produit> liste =g.getAllProduit();
		request.setAttribute("prods", liste);
		request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("rechercher")) {
			String mc = request.getParameter("mc") ; 
			request.setAttribute("prods", g.GetProduitByMc(mc)); 
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("delete")) {	
			int id =Integer.parseInt(request.getParameter("id"));
			g.DeleteProduit(id);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
			
		}
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
