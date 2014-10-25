package com.sudoko;

import java.util.Set;
import com.sudoko.components.Board;
import com.sudoko.components.Point;

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
		
		System.out.println("**** A possible solution is: ****");
		fBoard.print();
	}

	/**
	 * Method represents a move in Sudoko game.
	 */
	public void takeATurn() {
		// check if we have a solution
		if (fBoard.fEmptyPts.size() == 0) {
			fBoard.bIsAllFinished = true;
		} else {
			// Pick an open space
			Point currentPt = fBoard.findNextPoint();
			
			// Return a list of possible integer values
			Set<Integer> candidates = fBoard.generatePossibleValues(currentPt);
			
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

}