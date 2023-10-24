package goal;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		List<Node> explored = new LinkedList<>();
		explored.add(root);
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getChildren().equals(goal)) {
				return current; // Goal found, return the solution node
			} else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					double pathCost = current.getPathCost() + child.getWeight();
					Node end = child.getEnd();
					if (!explored.contains(end) && !frontier.contains(end)) {
						end.setPathCost(pathCost);
						frontier.add(end);
						end.setParent(current);
					} else if (end.getPathCost() > current.getPathCost()) {
						end.setPathCost(pathCost);
						end.setParent(current);
					}
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
}