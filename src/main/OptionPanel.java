package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OptionPanel extends JPanel implements ActionListener{

	private DrawPanel drawPanel;
	
	int panelX = Frame.frameX;
	int panelY = Frame.frameY;
	GridBagConstraints c = new GridBagConstraints();
	
	public OptionPanel() {
		setPreferredSize(new Dimension(panelX,panelY));
		setLayout(new GridBagLayout());
		
		build();
	}
	
	JTextField vertexSizeText, displaySizeText;
	JTextArea vertexInfo, displayInfo;
	String setVerticesSize, setDisplaySize;
	final int DISPLAY_MIN = 250;
	final int DISPLAY_MAX = 1080;
	boolean size,vertex;
	
	void build() {
		System.out.println("Building option panel");
		
		JButton run = new JButton("Run");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 3;
		run.addActionListener(this);
		add(run, c);
		
		//Size------------------------------------------------------------------
		displayInfo = new JTextArea();
		displayInfo.setText("Display size between 250 and 1080");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 1;
		add(displayInfo, c);
		
		displaySizeText = new JTextField();
		displaySizeText.setText("500");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 1;
		add(displaySizeText, c);
		
		//vertex Count---------------------------------------------------------
		vertexInfo = new JTextArea();
		vertexInfo.setText("Vertex size greater than or equal to 3:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 0;
		add(vertexInfo, c);
		
		vertexSizeText = new JTextField();
		vertexSizeText.setText("3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(vertexSizeText, c);
		
	}
	
	boolean read() {
		System.out.println("reading");
		setVerticesSize = vertexSizeText.getText();
		setDisplaySize = displaySizeText.getText();
		//Size input------------------------------------------------------
		try {	
			if(Integer.parseInt(setDisplaySize) > DISPLAY_MIN & Integer.parseInt(setDisplaySize) < DISPLAY_MAX ) {
				System.out.println("SIZE - read true");
				Frame.frameX = Integer.parseInt(setDisplaySize);
				Frame.frameY = Integer.parseInt(setDisplaySize);
				size = true;
			}
			else {
				
				displayInfo.setText("Thats not a number greater than 250 and less than 1080 at all");
				System.out.println("Read returned false, number not greater than 250 and less than 1080");
				
			}
		} catch (NumberFormatException e) {
			vertexInfo.setText("Really? Thats not a number");
			System.out.println("SIZE-Read returned false, number format exception");
  
	    }
		
		//Vertex input----------------------------------------------------
			try {	
				if(Integer.parseInt(setVerticesSize) >= 3) {
					System.out.println("VERTEX - read true");
					Vertex.verticesSize = Integer.parseInt(setVerticesSize);
					vertex = true;
				}
				else {
					
					vertexInfo.setText("Thats not a number greater than 3 now is it?");
					System.out.println("Read returned false, number not greater or equal to 3");
					
				}
			} catch (NumberFormatException e) {
				vertexInfo.setText("Thats not even a number");
				System.out.println("VERTICES-Read returned false, number format exception");
				
		    }
		if(size && vertex) {
			return true;
		}else return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
		if(read()) {
			System.out.println("attempting to build drawPanel");
			removeAll();
			setVisible(false);	
			
			Frame.window.setSize(Frame.frameX, Frame.frameY);
			
			drawPanel = new DrawPanel();
	        Frame.window.add(drawPanel);
		}

		
	}
}
