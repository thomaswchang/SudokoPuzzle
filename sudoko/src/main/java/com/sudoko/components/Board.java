package com.sudoko.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Board {
	public Board() {
		bIsAllFinished = false;
	}

	public final Point[][] fUnits = new Point[9][9];
	public final List<Line> fAllRows = new ArrayList<Line>();
	public final List<Line> fAllColumns = new ArrayList<Line>();
	public final Section[][] fAllSections = new Section[3][3];
	public boolean bIsAllFinished;
	public Queue<Point> fEmptyPts = new PriorityQueue<Point>();

	public Point findNextPoint() {
		return fEmptyPts.poll();
	}

	public void print() {
		for (int r = 0; r < fUnits.length; r++) {
			for (int c = 0; c < fUnits[r].length; c++) {
				System.out.println(fUnits[r][c].fValue + ", ");
			}
			System.out.println("\n");
		}
	}
	
	public Set<Integer> generateCompleteSet() {
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6,
				7, 8, 9));
		return s;
	}
	
	public void initialize() throws Exception {
		String csvFile = "resource/input.csv";
		String line = "";

		BufferedReader br = new BufferedReader(new FileReader(csvFile));
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

				this.fAllSections[row /3][col/3].addMember(p);

				this.fUnits[row][col] = p;

				col++;
			}
			row++;
		}
	}

}
