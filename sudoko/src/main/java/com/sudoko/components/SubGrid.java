package com.sudoko.components;

import java.util.Set;

/**
 * Class represents a 3x3 grid on a Sudoko board.
 */
public class SubGrid {
	public Set<Point> fMembers;

	public SubGrid(Set<Point> members) {
		fMembers = members;
	}

	public void addMember(Point p) {
		fMembers.add(p);
	}

	public int getNumEmpty() {
		int cnt=0;
		for (Point p : fMembers)
			if (p.fValue ==0)
				cnt ++;
		return cnt;
	}
}
