package mondrianSolution;

import java.awt.Rectangle;
import java.util.ArrayList;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Tester extends TestCase{

	public Tester() {
		super();
	}
	
	public void testRandom() {
		Mondrian m = new Mondrian();
		double random = m.getRandom();
		assertTrue(random > 0.33 && random < 0.67);
	}
	
	public void testRectangles() {
		Mondrian m = new Mondrian();
		ArrayList<Rectangle> rects = m.getRectangles();
		System.out.println(rects.size());
		//If this test fails, run again...occasionally, a sample will be smaller
		assertTrue(rects.size() > 30);
		
		ArrayList<Integer> areas = new ArrayList<Integer>();
		ArrayList<Integer> xValues = new ArrayList<Integer>();
		ArrayList<Integer> yValues = new ArrayList<Integer>();
		for(Rectangle r : rects) {
			areas.add(r.width * r.height);
			xValues.add(r.x);
			yValues.add(r.y);
		}
		
		int areaMatches = 0;
		int xyMatches = 0;
		for(int i = 0; i < areas.size(); i++) {
			for(int j = i+1; j < areas.size(); j++) {
				if(areas.get(i).equals(areas.get(j)))
					areaMatches++;
				if(xValues.get(i).equals(xValues.get(j)) && yValues.get(i).equals(yValues.get(j)))
					xyMatches++;
			}
		}
		assertTrue(areaMatches < rects.size()/10);
		assertTrue(xyMatches == 0);
	}
	
	private static TestSuite suite() {
		TestSuite suite = new TestSuite("Test for ReflectionUtilities.java");
		suite.addTestSuite(Tester.class);
		return suite;
	}
}
