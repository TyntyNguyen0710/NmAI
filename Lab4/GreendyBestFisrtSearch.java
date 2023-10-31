package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GreendyBestFisrtSearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
		ArrayList<String> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();

			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explored.add(current.getLabel());
				List<Edge> children = current.getChildren();

				for (Edge edge : children) {
					Node child = edge.getEnd();
					double newPathCost = current.getG() + edge.getWeight();

					if (!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(current);
						child.setG(newPathCost);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root == null)
			return null;
		PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
		ArrayList<String> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();

			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explored.add(current.getLabel());
				List<Edge> children = current.getChildren();

				for (Edge edge : current.getChildren()) {
					Node child = edge.getEnd();
					double newPathCost = current.getG() + edge.getWeight();

					if (!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(current);
						child.setG(newPathCost);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		AStarSearchAlgo aStarSearch = new AStarSearchAlgo();
		// chi phi thuc su tu root den goal
		Node trueCostNode = aStarSearch.execute(root, goal);
		// lay gia tri h(n) that su tu trueCostNode
		double trueCostH = trueCostNode.getG();
		// lay h(n) tu root
		double heuristicH = root.getH();

		if (heuristicH <= trueCostH && heuristicH >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
