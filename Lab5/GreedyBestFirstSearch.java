package Lab5;

import java.util.*;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<>();

		Node initialState = Puzzle.getInitialState();
		Node goalState = Puzzle.getGoalState();

		priorityQueue.add(initialState);

		while (!priorityQueue.isEmpty()) {
			Node current = priorityQueue.poll();
			
			if (current.equals(goalState)) {
				return current; // Solution found
			}
			explored.add(current);

			for (Node successor : Puzzle.getSuccessors(current)) {
				int heuristicValue = Puzzle.computeH1(successor); // Use h1 or h2 as needed
				if (!explored.contains(successor) && !priorityQueue.contains(successor)) {
					successor.setH(heuristicValue);
					priorityQueue.add(successor);
				}
			}
		}
		return null; // No solution found
	}

}
