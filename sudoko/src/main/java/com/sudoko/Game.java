package com.sudoko;

import java.util.Set;
import com.sudoko.components.Board;
import com.sudoko.components.Point;

/**
 * Class represents a Sudoko game, whereby each row, column, and 3x3 sub-grids
 * contains unique digits from 1 to 9.
 */
public class Game {
	private final Board fBoard;
	private final String fFilePath;
	
	public Game() {
		fBoard = new Board();
		fFilePath = "/src/main/java/com/sudoko/resource/input.csv";
	}
	
	public void startGame() throws Exception {
		try {
			fBoard.initFromCsv(fFilePath);
		} catch (Exception e) {
			String msg = String.format(
					"Sudoko board failed to initialize due to:\n %s ",
					e.getMessage());
			throw new Exception(msg);
		}
		
		System.out.println("Initial board configuration is:");
		fBoard.showAllValues();

		takeATurn();
		
		System.out.println("A possible solution is:");
		fBoard.showAllValues();
	}

	/**
	 * Method represents a move in Sudoko game.
	 */
	public void takeATurn() {
		// check if we have a solution
		if (fBoard.getAllBlankPts().size() == 0) {
			fBoard.setBoardIsFilled(true);
		} else {
			Point currentPt = fBoard.findNextOpenSpace();
			
			Set<Integer> candidates = fBoard.generatePossibleValues(currentPt);
			
			// If there are no candidates, look at this point later
			if (candidates.size() == 0)
				fBoard.getAllBlankPts().add(currentPt);
			
			for (Integer c : candidates) {
				currentPt.setValue(c);
					
				takeATurn();

				if (fBoard.isBoardFilled())
					return;
				else
					currentPt.setValue(0);
			}
		}
	}
}