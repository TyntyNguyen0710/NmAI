package goal;

import java.util.*;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	@Override
	// BFS
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> explored = new HashSet(); // task1,2
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current; // Find goal

			} else {
				explored.add(root); // task1,2
			}
			List<Node> children = current.getChildrenNodes();
			for (Node child : current.getChildrenNodes()) {
				if (!explored.contains(child) && !frontier.contains(child)) { // task1,2
					child.setParent(current);
					frontier.add(child);
					explored.add(child);
				}
			}
		}
		return null; // No path to the goal
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root == null)
			return null;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				// Goal node find
				return current;
			}

			for (Node child : current.getChildrenNodes()) {
				child.setParent(current);
				frontier.add(child);
			}
		}

		// Goal node not found
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}

}
