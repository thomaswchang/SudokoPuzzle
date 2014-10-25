package com.sudoko.components;

import java.util.HashSet;
import java.util.Set;

/**
 * Class represents a row or column on a Sudoko board.
 *
 */
public class Line {
	public Set<Point> fMembers;

	public Line() {
		fMembers = new HashSet<Point>();
	}

	public void add(Point pt) {
		fMembers.add(pt);
	}
	
	public int getNumEmpty() {
		int cnt=0;
		for (Point p : fMembers)
			if (p.fValue == 0)
				cnt ++;
		return cnt;
	}
	

}
