package com.sudoko.components;

public class Point {
	public final int fRow;
	public final int fColumn;
	public int fValue;

	public Point(int row, int column, int value) {
		fRow = row;
		fColumn = column;
		fValue = value;
	}
}
