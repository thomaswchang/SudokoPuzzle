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

/**
 * Class encapsulates a Sudoko board. A board consists of horizontal/vertical
 * lines and subGrids.
 * 
 */
public class Board {
	public final int SIZE = 9;
	
	private final Point[][] fPoints = new Point[SIZE][SIZE];
	private final List<Line> fAllRows = new ArrayList<Line>();
	private final List<Line> fAllColumns = new ArrayList<Line>();
	private final SubGrid[][] fAllSubGrids = new SubGrid[3][3];

	private boolean bIsAllFinished;
	private Stack<Point> fEmptyPts = new Stack<Point>();
		
	public Board() {
		bIsAllFinished = false;		
		for (int i=0; i<SIZE; i++) {
			this.fAllRows.add(new Line());
			this.fAllColumns.add(new Line());
		}
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				fAllSubGrids[i][j] = new SubGrid(new HashSet<Point>());
			}
		}
	}

	/**
	 * Method reads a csv file, which represents the initial values of a sudoko board.
	 * @throws Exception
	 */
	public void initialize() throws Exception {
		String filePath = new File("").getAbsolutePath().concat("/src/main/java/com/sudoko/resource/input.csv");
		String line = "";
		
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

				Line verticalLine =this.fAllColumns.get(col);
				verticalLine.add(p);

				this.fAllSubGrids[row/3][col/3].add(p);
				
				this.fPoints[row][col] = p;

				col++;
			}
			row++;
		}
	}
	
	/**
	 * Method returns a point that has an empty value.
	 */
	public Point findNextPoint() {
		if (fEmptyPts.size() == 0)
			return null;
		return fEmptyPts.pop();
	}

	/**
	 * Method prints the values of each point on the sudoko board.
	 */
	public void print() {
		for (int r = 0; r < fPoints.length; r++) {
			StringBuffer buffer = new StringBuffer();
			for (int c = 0; c < fPoints[r].length; c++) {
				buffer.append(fPoints[r][c].fValue);
				if (c < fPoints[r].length -1)
					buffer.append(", ");
			}
			System.out.println(buffer.toString());
		}
	}
	
	/**
	 * Method returns a set consisting of the numbers 1 to 9.
	 */
	public Set<Integer> generateCompleteSet() {
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6,
				7, 8, 9));
		return s;
	}
	
	/**
	 * Method generate all possible values for a given Point.
	 * 
	 * @param pt
	 * @return a set of integer values
	 */
	public Set<Integer> generatePossibleValues(Point pt) {
		Set<Integer> candidates = this.generateCompleteSet();

		Line horLine = this.fAllRows.get(pt.fRow);
		
		Line vertLine = this.fAllColumns.get(pt.fColumn);
		
		SubGrid subGrid = this.fAllSubGrids[pt.fRow/3][pt.fColumn/3];
		
		candidates.removeAll(horLine.getValueOfFillledPoints());
		candidates.removeAll(vertLine.getValueOfFillledPoints());
		candidates.removeAll(subGrid.getValueOfFillledPoints());
		
		return candidates;
	}

	/**
	 * Method returns all the points on the board
	 */
	public Point[][] getAllPts() {
		return fPoints;
	}
	
	/**
	 * Method returns all horizontal lines on the board
	 */
	public List<Line> getAllHorizontalLines() {
		return fAllRows;
	}
	
	/**
	 * Method returns all vertical lines on the board
	 */
	public List<Line> getAllVerticalLines() {
		return fAllColumns;
	}
	
	/**
	 * Method returns all sub-sections on the board
	 */
	public SubGrid[][] getAllSubSections() {
		return fAllSubGrids;
	}
	
	/**
	 * Method returns whether the board is filled.
	*/
	public boolean isBoardFilled() {
		return bIsAllFinished;
	}

	/**
	 * Method sets whether the board is filled.
	 */
	public void setBoardIsFilled(boolean state) {
		 bIsAllFinished = state;
	}
	
	/**
	 * Method returns a collection of non-filled points
	 */
	public Stack<Point> getEmptyPoints() {
		return fEmptyPts;
	}
}
