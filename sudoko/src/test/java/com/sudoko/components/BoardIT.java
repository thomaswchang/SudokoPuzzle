package com.sudoko.components;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

/**
 * Unit class for the Board class.
 */
public class BoardIT {
		
	@Test
	public void testInitializeMethod() throws Exception {
		Board board = new Board();
		board.initFromCsv();
		
		// Assert there are 81 Points
		int numPoints = board.getAllPts().length * board.getAllPts()[0].length;
		assertEquals("There should be 81 points", 81, numPoints);
		
		// Assert there are 9 horizontal lines
		assertEquals("There should be 9 horizontal lines", 9, board.getAllHorizontalLines().size());
		
		// Assert there are 9 vertical lines
		assertEquals("There should be 9 vertical lines", 9, board.getAllVerticalLines().size());		
		
		// Assert there are 9 sub-grids
		int numSubGrids = board.getAllSubSections().length * board.getAllSubSections()[0].length;
		assertEquals("There should be 9 sub grids s", 9, numSubGrids);		
	}

	@Test
	public void testFindNextPointMethodReturnsNullWhenBoardIsAllFilled() {
		Board board = new Board();
		
		Point p = board.findNextOpenSpace();
		assertEquals("An filled board returns a null pointer", null, p);
	}

	@Test
	public void testMethodFindNextPointReturnsAPointWhenBoardIsNotAllFilled() throws Exception {
		Board board = new Board();
		board.initFromCsv();
		
		Point p = board.findNextOpenSpace();

		assertEquals("An non-filled board returns a point object",
				"class com.sudoko.components.Point", p.getClass().toString());
	}
	
	@Test
	public void testMethodGeneratePossibleValuesForANonFilledBoard() {
		Board board = new Board();
		
		Point currPt = new Point(0,0, 1);
		Set<Integer> values = board.generatePossibleValues(currPt);
		
		Set<Integer> aFilledLine = board.generateCompleteSet();
		
		for (Integer i : aFilledLine) {
			assertTrue("Value is missing.", values.contains(i));
		}
		
	}	
}
