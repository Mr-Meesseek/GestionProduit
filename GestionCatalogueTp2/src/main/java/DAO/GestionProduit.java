package DAO;
import java.sql.*;
import java.util.* ; 
import entities.Produit; 
public class GestionProduit implements ImplementProduit {

	@Override
	public void addProduit(Produit p) {
		Connection cx = SangletonConnection.getConnection()	;
		
		try {
			PreparedStatement st = cx.prepareStatement("insert into t_produit (id,name,Prix,Quantite) values (?,?,?,?)") ;
			st.setInt(1,p.getId()) ; 
			st.setString(2,p.getName()) ; 
			st.setFloat(3,p.getPrix()) ; 
			st.setInt(4,p.getQuantite()) ; 
			st.executeUpdate();
			System.out.print("the product have been added \n");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> getAllProduit() {
		Connection cx = SangletonConnection.getConnection()	; 
		List<Produit> liste = new ArrayList<>();
		try {
		PreparedStatement ps = cx.prepareStatement("select * from t_produit ") ;
		ResultSet rs = ps.executeQuery() ;
		while (rs.next()) {
			Produit p = new Produit();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrix(rs.getFloat(3));
			p.setQuantite(rs.getInt(4)) ; 
			liste.add(p);
				
		}
		
		}catch (SQLException e1){
			e1.printStackTrace(); 
			}
		return liste ; 
		}

	@Override
	public void DeleteProduit(int id) {
		Connection cx = SangletonConnection.getConnection();
		try {
			PreparedStatement st = cx.prepareStatement("delete from t_produit where id=?") ; 
			st.setInt(1, id);
			st.executeUpdate(); 
			System.out.print("the product have been deleted \n");
		}catch(SQLException e11) {
			e11.printStackTrace();
		}
		
	}

	@Override
	public Produit getProduit(int id) {
		Connection cx = SangletonConnection.getConnection();
		Produit p=null ; 
		try {
			PreparedStatement ps = cx.prepareStatement("select * from t_produit where id=?"); 
			ps.setInt(1,id);
			ResultSet rs =ps.executeQuery(); 
			if(rs.next()) {
				p=new Produit(); 
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2)); 
				p.setPrix(rs.getFloat(3));
				p.setQuantite(rs.getInt(4));
			}
		}catch(SQLException ee)
		{ee.printStackTrace();
			
		}
		return p;
	}

	@Override
	public void ModifyProduit(Produit p) {
		Connection cx = SangletonConnection.getConnection();
		try {
			PreparedStatement st = cx.prepareStatement("update t_produit set name=? ,prix=? , quantite=? where id=? ") ; 
			st.setString(1, p.getName());
			st.setFloat(2, p.getPrix());
			st.setInt(3, p.getQuantite());
			st.setInt(4, p.getId());
			st.executeUpdate(); 
			System.out.print("the product have been modified \n");
			}catch(SQLException e1)
		{
				e1.printStackTrace();
}
		
		
	
		
	}

	@Override
	public List<Produit> GetProduitByMc(String mc) {
		Connection cx = SangletonConnection.getConnection();
		List<Produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from t_produit where name like ? ") ; 
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit() ; 
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrix(rs.getFloat(3));
				p.setQuantite(rs.getInt(4));
				liste.add(p); 
			}}catch (SQLException ez) {
			ez.printStackTrace();
		}
		
		return liste;
	}
	
	
	}





