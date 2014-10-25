package com.sudoko;

import java.util.Set;
import com.sudoko.components.Board;
import com.sudoko.components.Line;
import com.sudoko.components.Point;
import com.sudoko.components.SubGrid;

/**
 * Class represents a Sudoko game, whereby each row, column, and 3x3 sub-grids
 * contains unique digits from 1 to 9.
 * 
 */
public class Game {
	private final Board fBoard;
	
	public Game() {
		fBoard = new Board();
	}
	
	public void play() throws Exception {
		fBoard.initialize();
		
		System.out.println("**** Initial board is: ****");
		fBoard.print();

		takeATurn();
		
		System.out.println("**** Here is a possible solution: ****");
		fBoard.print();
	}

	/**
	 * Method encapsulates a move in Sudoko game.
	 */
	public void takeATurn() {
		// check if we have a solution
		if (fBoard.fEmptyPts.size() == 0) {
			fBoard.bIsAllFinished = true;
		} else {
			// Pick an open space
			Point currentPt = fBoard.findNextPoint();
			
			// Return a list of possible integer values
			Set<Integer> candidates = generatePossibleValues(currentPt);
			
			for (Integer c : candidates) {
				currentPt.fValue = c;
					
				takeATurn();

				if (fBoard.bIsAllFinished)
					return;
				else
					currentPt.fValue = 0;
			}
		}
	}

	/**
	 * Method generate all possible values for a given Point.
	 * 
	 * @param pt
	 * @return a set of integer values
	 */
	public Set<Integer> generatePossibleValues(Point pt) {
		Set<Integer> candidates = fBoard.generateCompleteSet();

		Line lRow = fBoard.fAllRows.get(pt.fRow);
		Line lCol = fBoard.fAllColumns.get(pt.fColumn);
		SubGrid s = fBoard.fAllSections[pt.fRow/3][pt.fColumn/3];

		candidates.removeAll(lRow.fMembers);
		candidates.removeAll(lCol.fMembers);
		candidates.removeAll(s.fMembers);

		return candidates;
	}
}
