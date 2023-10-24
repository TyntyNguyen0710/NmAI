package goal;

import java.util.*;

import org.hamcrest.core.StringContains;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		if (root == null)
			return null;// Stack for DFS
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		Set<Node> explored = new HashSet<>(); // Set to track explored nodes //task1,2
		while (!frontier.isEmpty()) {
			Node current = frontier.pop(); // Pop the node
			explored.add(current); // task1,2
			if (current.getLabel().equals(goal)) {
				return current;// find goal
			}
			List<Node> children = current.getChildrenNodes();
			for (int i = children.size() - 1; i >=0 ;i--) {
				if (!explored.contains(children.get(i)) && !frontier.contains(children.get(i))) { // task1,2
					children.get(i).setParent(current);
					frontier.add(children.get(i));
					explored.add(children.get(i));
				}
			}
		}
		return null;
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
