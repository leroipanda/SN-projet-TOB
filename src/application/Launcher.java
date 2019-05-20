package fr.enseeiht.tob;

import fr.enseeiht.tob.system.Application;

public class Launcher {

	public static void main(String[] args) {
		Application app = new Application("TOB");
		app.launch();
	}

}
