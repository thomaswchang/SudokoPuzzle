package com.sudoko.components;

import java.util.HashSet;

/**
 * Class represents a row or column on a Sudoko board.
 */
public class Line extends Element{
	
	public Line() {
		super(new HashSet<Point>());
	}
	
}
