package bdd;
// A modifier pour éviter de tout importer
import java.sql.*;
/**
 * 
 * @author irodrigu4
 * Classe permettant d'établir une connexion avec la base de données.
 * Le choix a été fait d'utiliser Sqlite
 * Documentation ici : https://www.javadoc.io/doc/org.xerial/sqlite-jdbc/3.27.2.1 
 */
public class Bdd {
	Connection conn;
	
	public Bdd () {
		String nomBdd = "historiqueColis.db";
		String requeteTableColis = "CREATE TABLE IF NOT EXISTS colis (\n"
									+"ID int(11) NOT NULL,\n"
									+"destination varchar(30) NOT NULL,\n"
									+"categorie varchar(30) NOT NULL,\n"
									+"poids double NOT NULL,\n"
									+"etat varchar(30) NOT NULL,\n"
									+"prioritaire int(11) NOT NULL\n"
									+");";

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:"+nomBdd)) {
			// DriverManager.getConnection("jdbc:sqlite:" + DBPath);
			Class.forName("org.sqlite.JDBC");
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Le nom du driver est :"+ meta.getDriverName());
				// la base de données est créée si elle n'existait pas avant
				// Class.forName("org.sqlite.JDBC");
				Statement stmt = conn.createStatement();
				stmt.execute(requeteTableColis);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void connect () {
		try {
	        Class.forName("org.sqlite.JDBC");
	        conn = DriverManager.getConnection("jdbc:sqlite:historiqueColis.db");
	        // Statement stmt = conn.createStatement();
	        System.out.println("Connexion a la bdd avec succès");
	    } catch (ClassNotFoundException notFoundException) {
	        notFoundException.printStackTrace();
	        System.out.println("Erreur de connecxion");
	    } catch (SQLException sqlException) {
	        sqlException.printStackTrace();
	        System.out.println("Erreur de connecxion");
	    }
	}
	
	public static void main(String[] args) {	
	}
}
