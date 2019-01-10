package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{

	static int panelX = Frame.frameX;
	static int panelY = Frame.frameY;
	
	int iterations = 0;
	
	Font font = new Font("Times New Roman", Font.BOLD, 26);
    
	
//---------------------------------------------------------------------------	
	public DrawPanel() {
		
		System.out.println("Draw panel building");
		setPreferredSize(new Dimension(panelX,panelY));
	    setVisible(true);
	    removeAll();
	    System.out.println("Draw panel built");
			
	}
//---------------------------------------------------------------------------
    @Override
    public void update(Graphics g) {
    	repaint();
    }
    
//---------------------------------------------------------------------------
    public void repaint() {
        super.repaint();
    }	

//---------------------------------------------------------------------------
    public void paintComponent(Graphics g) {

    	if(iterations == 0) {
    		System.out.println("first iteration setup");
    		g.setFont(font);
    	    
    		g.setColor(Color.white);
        	g.fillRect(0, 0, panelX, panelY);
        	
        	System.out.println("Attempting to create vertices");
        	Vertex.createVertices();
        	
        	g.setColor(Color.black);
        	for (int i = 0; i<Vertex.vertices.size(); i++) {
	            System.out.println("Drawing vertex "+i);
        		
	            g.fillRect(Vertex.vertices.get(i).getX(), Vertex.vertices.get(i).getY(), 5, 5);
	            
        	}
		
        	Point.pointX=Vertex.vertices.get(0).getX();
        	Point.pointY=Vertex.vertices.get(0).getY();
        	
    	}
    	
    	//System.out.println("Draw panel drawing");
    	    		
    	g.fillRect(Point.pointX, Point.pointY, 1,1);
    	
    	Point.newPoint();
        	
        iterations++;
        
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 50);
        g.setColor(Color.black);
        g.drawString("Iterations: "+iterations, 0, 30);
      
        update(g);
    }


//--------------------------------------------------------------------------

	
	
}
