package com.sudoko.components;

/**
 * Class represents a singular box on a Sudoko board.
 *
 */
public class Point {
	public final int fRow;
	public final int fColumn;
	public int fValue;

	public Point(int row, int column, int value) {
		fRow = row;
		fColumn = column;
		fValue = value;
	}
	
	public String toString() {
		return String.format("Pt[%d][%d]=%d", fRow, fColumn, fValue);
	}
}
