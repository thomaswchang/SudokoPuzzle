package com.sudoko.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Board {
	public final int SIZE = 9;
	public final Point[][] fUnits = new Point[SIZE][SIZE];
	public final List<Line> fAllRows = new ArrayList<Line>();
	public final List<Line> fAllColumns = new ArrayList<Line>();
	public final Section[][] fAllSections = new Section[3][3];
	public boolean bIsAllFinished;
	public Stack<Point> fEmptyPts = new Stack<Point>();

	public Board() {
		bIsAllFinished = false;		
		for (int i=0; i<SIZE; i++) {
			this.fAllRows.add(new Line());
			this.fAllColumns.add(new Line());
		}
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				fAllSections[i][j] = new Section(new HashSet<Point>());
			}
		}
	}

	public Point findNextPoint() {
		return fEmptyPts.pop();
	}

	public void print() {
		for (int r = 0; r < fUnits.length; r++) {
			StringBuffer buffer = new StringBuffer();
			for (int c = 0; c < fUnits[r].length; c++) {
				buffer.append(fUnits[r][c].fValue);
				if (c < fUnits[r].length -1)
					buffer.append(", ");
			}
			System.out.println(buffer.toString());
		}
	}
	
	public Set<Integer> generateCompleteSet() {
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6,
				7, 8, 9));
		return s;
	}
	
	public void initialize() throws Exception {
		String line = "";
		
		String filePath = new File("").getAbsolutePath().concat("/src/main/java/com/sudoko/resource/input.csv");
		System.out.println("TWC1: filepath=" + filePath);

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		int row = 0;
		while ((line = br.readLine()) != null) {
			int col = 0;
			for (String t : line.split(",")) {
				int value = Integer.parseInt(t);
				Point p = new Point(row, col, value);

				if (value == 0)
					this.fEmptyPts.add(p);

				Line horizontalLine = this.fAllRows.get(row);
				horizontalLine.add(p);

				Line verticalLine =this.fAllRows.get(col);
				verticalLine.add(p);

				this.fAllSections[row/3][col/3].addMember(p);
				this.fUnits[row][col] = p;

				col++;
			}
			row++;
		}
	}

}
