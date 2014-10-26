package com.sudoko.components;

/**
 * Class represents a singular box on a Sudoko board.
 */
public class Point {
	private final int fRow;
	private final int fColumn;
	private int fValue;

	public Point(int row, int column, int value) {
		fRow = row;
		fColumn = column;
		fValue = value;
	}
	
	public int getRowNumber() {
		return fRow;
	}
	
	public int getColumnNumber() {
		return fColumn;
	}
	
	public int getValue() {
		return fValue;
	}
	
	public void setValue(int value) {
		fValue = value;
	}
	
	public String toString() {
		return String.format("Pt[%d][%d]=%d", fRow, fColumn, fValue);
	}
}
