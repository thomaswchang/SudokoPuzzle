package com.sudoko.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Base class for Sudoko components
 *
 */
public class Element {
	public Set<Point> fMembers;

	public Element(Set<Point> members) {
		fMembers = members;
	}
	
	public void add(Point p) {
		fMembers.add(p);
	}

	public List<Integer> getValueOfFillledPoints() {
		List<Integer> values = new ArrayList<Integer>();
		for (Point p : fMembers) {
			int val = p.fValue;
			if (val != 0)
				values.add(val);
		}
		return values;		
	}
	
	public int getNumEmpty() {
		int cnt=0;
		for (Point p : fMembers)
			if (p.fValue ==0)
				cnt ++;
		return cnt;
	}
}
