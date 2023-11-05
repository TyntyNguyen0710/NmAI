package Lab5;

import java.util.*;

public class AStarSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		Set<Node> explored = new HashSet<>();

		Node initialState = Puzzle.getInitialState();
		Node goalState = Puzzle.getGoalState();

		priorityQueue.add(initialState);

		while (!priorityQueue.isEmpty()) {
			Node current = priorityQueue.poll();

			if (current.equals(goalState)) {
				return current; // Found
			}

			explored.add(current);

			for (Node successor : Puzzle.getSuccessors(current)) {
				int gValue = current.getG() + 1; // Increment g(n) for the successor
				int heuristicValue = Puzzle.computeH1(successor); // Use h1 or h2 as needed
				int fValue = gValue + heuristicValue;

				if (!explored.contains(successor) && !priorityQueue.contains(successor)) {
					successor.setG(gValue);
					successor.setH(heuristicValue);
					priorityQueue.add(successor);
				}
			}
		}
		return null;
	}

}
