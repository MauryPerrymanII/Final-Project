package mondrianSolution;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import java.lang.Math;

public class Mondrian {

	private static int WIDTH = 1024;
	private static int HEIGHT = 768;

	private Random rand;
	private ArrayList<Rectangle> rectangles;
	
	private static final double SPLIT_PENALTY = 0.3; // Example value, replace with your desired value
    private static final int SPLIT_LOW = 50; // Example value, replace with your desired value

    
	
	
	
	
	
	
	
	//Constructor - initializes the random number generator and an arraylist
	public Mondrian() {
		rand = new Random();
		rectangles = new ArrayList<Rectangle>();
	}
	
	//TODO: get a new random double or float until it's between
	//.33 and .67, return the random number
	public double getRandom() {
		
		 double randomValue;
		    do {
		        randomValue = rand.nextDouble();
		    } while (randomValue <= 0.33 || randomValue >= 0.67);
		    return randomValue;
		
		
		
		
		

		
	}
	
	//TODO: split both the vertical and horizontal regions of the rectangle
	//The horizontal and vertical split points are based on a random number - 
	//use the getRandom() helper method
	//TODO: invoke the mondrianArt method on all four quadrants
	private void splitBoth(int x, int y, int w, int h) {
		
	    splitHorizontal(x, y, w, h);
	    splitVertical(x, y, w, h);
		
	}
	
	//TODO: Split so that the regions are side by side, invoke mondrianArt on both halves
	//TODO: the horizontal split point is based on a random number, use the helper method
	private void splitHorizontal(int x, int y, int w, int h) {
		
		
		 double randomSplit = getRandom();
		    int splitPoint = (int) (randomSplit * w);
		    mondrianArt(x, y, splitPoint, h);
		    mondrianArt(x + splitPoint, y, w - splitPoint, h);
		

	}

	//TODO: Split so that one region is above the other, invoke mondrianArt on both halves
	//TODO: the vertical split point is based on a random number, use the helper method
	private void splitVertical(int x, int y, int w, int h) {
		
		 double randomSplit = getRandom();
		    int splitPoint = (int) (randomSplit * h);
		    mondrianArt(x, y, w, splitPoint);
		    mondrianArt(x, y + splitPoint, w, h - splitPoint);
		
		
		
		
		
		
		
		

	}
		    
	//TODO: use recursion to draw "art" in a Mondrian style
	//Hint: use the algorithm in the project description
	private void mondrianArt(int x, int y, int w, int h) {
	    if(w > WIDTH / 2 && h > HEIGHT / 2) 
	        splitBoth(x, y, w, h);
	    else if(w > WIDTH / 2) 
	        splitHorizontal(x, y, w, h);
	    else if(h > HEIGHT / 2) 
	        splitVertical(x, y, w, h);
	    else {
	    	int maximum = (int) Math.max(Math.round(SPLIT_PENALTY * w) + 1, SPLIT_LOW + 1);
	    	int hsplit = rand.nextInt(maximum - SPLIT_LOW + 1) + SPLIT_LOW;
	    	int vsplit = rand.nextInt(maximum - SPLIT_LOW + 1) + SPLIT_LOW;
	    	
	    	if (hsplit < w && vsplit < h)
	    		splitBoth(x, y, w, h);
	    	else if(hsplit < w)
	    		splitHorizontal(x, y, w, h);
	    	else if(vsplit < h) 
	    		splitVertical(x, y, w, h);
	    	else
		    	rectangles.add(new Rectangle(x, y, w, h));
	    }
	}
	
	//Invokes the mondrianArt method to create the rectangles recursively
	public ArrayList<Rectangle> getRectangles(){
		mondrianArt(0, 0, WIDTH, HEIGHT);
		return rectangles;
	}
}
