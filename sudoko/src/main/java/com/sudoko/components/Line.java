package com.sudoko.components;

import java.util.HashSet;
import java.util.Set;

public class Line {
	public Set<Point> fMembers;

	public Line() {
		fMembers = new HashSet<Point>();
	}

	public void add(Point pt) {
		fMembers.add(pt);
	}

}
