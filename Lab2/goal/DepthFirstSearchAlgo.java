package goal;

import java.util.*;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		if (root == null)
			return null;// Stack for DFS
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
//		Set<Node> explored = new HashSet<>(); // Set to track explored nodes //task1,2
		while (!frontier.isEmpty()) {
			Node current = frontier.pop(); // Pop the node
//			explored.add(current); //task1,2
			if (current.getLabel().equals(goal)) {
				return current;// find goal
			}

//			List<Node> children = current.getChildrenNodes();
			for (Node child : current.getChildrenNodes()) {
//				if (!explored.contains(child) && !frontier.contains(child)) { //task1,2
					child.setParent(current);
					frontier.push(child);

				}
			}
//		}
		return null; // Goal not found
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root == null)
			return null;
		Stack<Node> frontier = new Stack<>();
		Set<Node> explored = new HashSet<>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			explored.add(currentNode);
			if (currentNode.getLabel().equals(goal)) {
				// Goal node found, reconstruct the path from 'start' to 'goal' and return it
				return currentNode;
			}
			for (Node child : currentNode.getChildrenNodes()) {
				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(currentNode);
					frontier.push(child);
				}
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
