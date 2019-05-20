package OptimisationRangement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Truckz.Camion;
import Truckz.Colis;

public class AlgoKnapsackTest {

	Camion camionTest = new Camion("test", 100);

	Colis colis1 = new Colis("idcolis1", true, null, 20, null);
	Colis colis2 = new Colis("idcolis2", true, null, 40, null);
	Colis colis3 = new Colis("idcolis3", false, null, 40, null);

	@Test
	public void testAlgoKnapsack() {

		colis3.addPriorite(1);
		ArrayList<Colis> listeColis = new ArrayList<Colis>();
		listeColis.add(colis1);
		listeColis.add(colis2);
		listeColis.add(colis3);
		AlgoKnapsack testAlgo = new AlgoKnapsack(listeColis, (int)camionTest.getPoidsMax());
		testAlgo.resoudre(camionTest);
		for (int i = 0; i < listeColis.size(); i++) {
			assertEquals(camionTest.contientColis(listeColis.get(i).getId()), true);
		}
	}
}