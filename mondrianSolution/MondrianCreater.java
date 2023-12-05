package mondrianSolution;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MondrianCreater extends JPanel {
	
	//Establishes the frame and panel to display the rectangles
	public static void main(String[] args) {
		JFrame frame = new JFrame("My Drawing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new MondrianCreater();
		panel.setSize(1024,768);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	//TODO: select a color randomly (choose your color scheme, you need a minimum of four colors)
	public static Color getColor() {
		Random rand = new Random();
		  int randNum = rand.nextInt(4);
		  switch (randNum) {
	        case 0:
	            return Color.red;
	        case 1:
	            return Color.blue;
	        case 2:
	            return Color.yellow;
	        case 3:
	            return Color.white;
	        default:
	            return Color.black; // Default color
		  }
	}
	
	//Draws the rectangles on the screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Mondrian m = new Mondrian();
		ArrayList<Rectangle> rects = m.getRectangles();
		for(Rectangle r : rects) {
	    	g.setColor(Color.black);
	    	g.drawRect(r.x, r.y, r.width, r.height);
			g.setColor(getColor());
			g.fillRect(r.x, r.y, r.width, r.height);
		}
	}

}


