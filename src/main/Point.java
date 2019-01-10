package main;

import java.util.ArrayList;

public class Point {

	
	//For new points-----------------------------------------------------------------------------------------------
	
	static int pointX;
	static int pointY;
	
	static void newPoint() {
		
		int direction = randomDirection();
		
		//System.out.println(direction);
		//System.out.println(points.get(direction));
		
		pointX = (Vertex.vertices.get(direction).getX() + pointX)/2;
		pointY = (Vertex.vertices.get(direction).getY() + pointY)/2;
		
	}
	
	static int randomDirection() {
		
		int randomDirection = (int )(Math.random() * Vertex.verticesSize); //Three for triangle first example
		return randomDirection;
		
	}
}
