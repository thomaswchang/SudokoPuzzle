package com.sudoko.components;

import java.util.Set;

public class Section {
	public Set<Point> fMembers;

	public Section(Set<Point> members) {
		fMembers = members;
	}

	public void addMember(Point p) {
		fMembers.add(p);
	}

}
