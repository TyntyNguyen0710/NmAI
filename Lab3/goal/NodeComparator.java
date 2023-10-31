package goal;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node node1, Node node2) {
		int re = Double.compare(node1.getPathCost(), node2.getPathCost());
		if (re == 0) {
			return node1.getLabel().compareTo(node2.getLabel());
		} else
			return re;
	}
}
