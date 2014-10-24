package com.sudoko;
import java.util.Set;

import com.sudoko.components.Board;
import com.sudoko.components.Line;
import com.sudoko.components.Point;
import com.sudoko.components.Section;

public class Game {
	public final Board board = new Board();

	public void play() throws Exception {

		board.initialize();
		board.print();

		Point p = board.findNextPoint();
		backTrack(p);
	}

	public void backTrack(Point currentPt) {
		// check if we have a solution
		if (board.fEmptyPts.size() == 0) {
			board.bIsAllFinished = true;
		} else {
			Set<Integer> candidates = generateCandidates(currentPt);

			for (Integer c : candidates) {
				// get point, and assign it a value of c
				currentPt.fValue = c;

				Point next = board.findNextPoint();
				backTrack(next);

				currentPt.fValue = 0;

				if (board.bIsAllFinished)
					return;
			}
		}
	}

	public Set<Integer> generateCandidates(Point pt) {
		Set<Integer> candidates = board.generateCompleteSet();

		Line lRow = board.fAllRows.get(pt.fRow);
		Line lCol = board.fAllColumns.get(pt.fColumn);
		Section s = board.fAllSections[pt.fRow / 3][pt.fColumn / 3];

		candidates.removeAll(lRow.fMembers);
		candidates.removeAll(lCol.fMembers);
		candidates.removeAll(s.fMembers);

		return candidates;
	}

}
