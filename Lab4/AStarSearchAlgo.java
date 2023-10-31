package Lab4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
		HashSet<String> explored = new HashSet<>();
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
					double newG = current.getG() + edge.getWeight();
					double newH = newG + current.getH();
					if (!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(current);
						child.setG(newG);
						child.setH(newH);
						frontier.add(child);
						explored.contains(current);
					} else if (frontier.contains(child) && child.getG() > newG) {
						frontier.remove(child);
						child.setG(newG);
						child.setH(newG + (child.getH() - child.getG()));
						frontier.add(child);
						child.setParent(current);

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
		Node startNode = new Node(start);
		Node goalNode = new Node(goal);
		PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
		HashSet<String> explored = new HashSet<>();
		frontier.add(root);
		explored.add(start);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
	
			if (current.getLabel().equals(goal)) {
				return current; // Trả về nút mục tiêu nếu tìm thấy
			} else {
				explored.add(current.getLabel());
				List<Edge> children = current.getChildren();

				for (Edge edge : children) {
					Node child = edge.getEnd();
					double newG = current.getG() + edge.getWeight();
					double newH = newG + child.getH(); // Sử dụng giá trị heuristic (h) của nút con

					if (!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(current);
						child.setG(newG);
						child.setH(newH);
						frontier.add(child);
					} else if (frontier.contains(child) && newG < child.getG()) {
						// Cập nhật nút con nếu có một đường đi tốt hơn
						child.setParent(current);
						child.setG(newG);
						child.setH(newH);
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
