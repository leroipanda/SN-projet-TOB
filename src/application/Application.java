package fr.enseeiht.tob.system;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private String title;
	private JFrame jframe;
	private GoogleMap googleMap;
	
	public Application(String title) {
		this.title = title;
		this.googleMap = new GoogleMap(5.0d, 43.6043, 1.4437);
	}
	
	public void launch() {
		this.jframe = new JFrame(title);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.add(googleMap.getMapView(), BorderLayout.CENTER);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	
	public String getTitle() {
		return title;
	}
	
}
