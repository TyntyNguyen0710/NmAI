package Lab6_1;

import java.util.*;

public class HillClimbingSearchNQueen {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node execute(Node initialState) {
		Node current = initialState;

		while (true) {
			stepClimbed++;

			List<Node> neighbors = current.generateAllCandidates();
			Node next = null;

			for (Node neighbor : neighbors) {
				if (neighbor.getH() < current.getH()) {
					next = neighbor;
					break;
				}
			}

			if (next == null || next.getH() >= current.getH()) {
				// Reached a local optimum or peak
				break;
			}

			current = next;
		}

		return current;
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node state = execute(initialState);

		while (state.getH() != 0) {
			randomRestarts++;
			stepClimbedAfterRandomRestart += stepClimbed;

			// Generate new configuration of N Queens
			state.generateBoard();
			state = execute(state);
		}

		return state;
	}
}
