package com.sudoko.components;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


/**
 * Unit test for the Element class, which is the parent of the Line and SubGrid
 * classes.
 */
public class ElementIT {

	@Test
	public void testMethodGetValueOfFillledPoints() {
		int pointValue = 5;
		Element e = createElementWithOneValue(1,1, pointValue);
		assertTrue("Element contains value", e.getValueOfFillledPoints()
				.contains(pointValue));
	}

	@Test
	public void getNumEmpty() {
		int pointValue = 0;
		Element e = createElementWithOneValue(1,1, pointValue);
		assertEquals("Expect 1 elements with empty value", 1, e.getNumEmpty());
	}
	
	private Element createElementWithOneValue(int row, int column, int value) {
		Point p = new Point(1,1, value);
		
		Set<Point> s = new HashSet<Point>();
		s.add(p);
		
		Element e = new Element(s);
		return e;
	}
	
}
