package main;

import java.util.ArrayList;
import java.lang.Math;

public class Vertex {

	int x;
	int y;
	static double r = (DrawPanel.panelY/2)- (DrawPanel.panelY/10);
	
	static int verticesSize;
	static ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	
	
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

		
	
	
	
	static void createVertices() {
		
		System.out.println("Creating vertices");
		for(int i = 0; i < verticesSize;i++) {
			
			vertices.add(new Vertex(positionX(i),positionY(i)));

		}
		System.out.println("Vertices created");
		
	}
	
	static int positionX(int ordinal) {
		
		double theta = (double)(ordinal*((2*Math.PI)/verticesSize));
		int x =(int)(r*Math.cos(theta));
		return x+(DrawPanel.panelY/2);
		
	}
	
	static int positionY(int ordinal) {
		
		double theta = (double)(ordinal*((2*Math.PI)/verticesSize));
		int y =(int)(r*Math.sin(theta));
		return y+(DrawPanel.panelY/2);
	}
}
