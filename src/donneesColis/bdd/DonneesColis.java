// Non relié à la classe Colis, d'où les erreurs
package bdd;
import java.util.ArrayList;
import Elements.Categorie;
import Elements.Colis;
import Elements.Entrepot;
import Elements.EtatColis;
import geolocalisation.position;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.sql.Timestamp;
/**
 * 
 * @author irodrigu4
 * Classe permettant de récuperer les données sur les colis
 * présents dans le fichier texte
 *
 */
public class DonneesColis {
	
	Connection conn;
	Bdd bdd;
	
	public DonneesColis() {
		this.bdd = new Bdd();
		this.conn = bdd.conn;
		
	}
	
	public void connect() {
		this.bdd.connect();
		conn = bdd.conn;
	}
	
	public ArrayList<Colis> recupererListeColis(int n) throws SQLException {
		ArrayList<Colis> listeColis = new ArrayList<Colis>();
		String requete = "SELECT * from colis ORDER BY ID DESC LIMIT 0,"+n;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(requete);
		while(rs.next()) {
			// rs.getInt("id"), rs.getString("name")...;
			Entrepot entrepot = new Entrepot(rs.getString("destination"), new position(456,874));
			Colis colis = new Colis(rs.getString("ID"), rs.getBoolean("prioritaire"), Categorie.N, 
					rs.getDouble("poids"), entrepot);	
			listeColis.add(colis);
			
		}
		return listeColis;
	}
	
	/* Obtenir un objet colis à partir de son id (unique) */
	public Colis getColis(String i) throws SQLException {
		String requete = "SELECT * from colis ORDER BY ID DESC WHERE ID = "+i;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(requete);
		Entrepot entrepot = new Entrepot(rs.getString("destination"), new position(456,874));
		// rs.getString("categorie") à ajouter
		Colis colis = new Colis(rs.getString("ID"), rs.getBoolean("prioritaire"), Categorie.N, 
					rs.getDouble("poids"), entrepot);
		return colis;
	}
	
	/* Ajouter un colis à la base de données */
	public void addColis(Colis colis) {
		String query = "";
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		query += "INSERT INTO colis VALUES (";
		query += colis.getId()+ ", ";
		query += "'" +colis.getDestination()+ "', ";
		query += "'" +"Normal"+ "', ";
		query += colis.getPoids()+ ", ";
		query += "'" +colis.getEtat()+ "', ";
		query +=  colis.getPriorite()+")";
		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Supprimer un colis de la base de données */
	public void supprimerColis(int idColis) throws SQLException {
		String sql = "DELETE FROM colis WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idColis);
		pstmt.executeUpdate();
	}
	
	/* Modifier l'état d'un colis présent dans la base de données */
	public void majColis(String id, EtatColis etat) {
		
	}
}
