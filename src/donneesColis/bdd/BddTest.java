package bdd;

import Elements.Categorie;
import Elements.Colis;
import Elements.Entrepot;
import geolocalisation.position;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class BddTest {

	// Bdd bdd = new Bdd();
	DonneesColis donneesColis= new DonneesColis();
	Entrepot entrepot = new Entrepot("Maison de Jul", new position(456,874));
	Colis colis1 = new Colis("12", false, Categorie.N, 125.5, entrepot);
	
	@Test
	public void test() throws SQLException {
		donneesColis.connect();
		donneesColis.addColis(colis1);
		// Colis colis = donneesColis.getColis("12");
		// System.out.println(colis.getPoids());
	}

}
