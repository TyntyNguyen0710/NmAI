package goal;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
        // Compare nodes based on their path costs
        double pathCost1 = node1.getPathCost();
        double pathCost2 = node2.getPathCost();

        if (pathCost1 < pathCost2) {
            return -1; // Node 1 has a lower cost, so it comes first.
        } else if (pathCost1 > pathCost2) {
            return 1;  // Node 2 has a lower cost, so it comes first.
        } else {
            return 0;  // Both nodes have the same cost.
        }
    }
}
