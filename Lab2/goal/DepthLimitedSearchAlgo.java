package goal;

public class DepthLimitedSearchAlgo implements ISearchAlgo{
	 @Override
	    public Node execute(Node root, String goal, int limitedDepth) {
	        if (root == null || goal == null) return null;

	        Node result = recursiveDLS(root, goal, limitedDepth);
	        if (result != null && result.getLabel().equals(goal)) {
	            // Goal node found, return the result
	            return result;
	        } else {
	            // Goal node not found within the limited depth
	            return null;
	        }
	    }

	    private Node recursiveDLS(Node node, String goal, int limit) {
	        if (node.getLabel().equals(goal)) {
	            // Goal node found, return it
	            return node;
	        } else if (limit == 0) {
	            // Depth limit reached, return cutoff
	            return null;
	        } else {
	            boolean cutoffOccurred = false;
	            for (Edge edge : node.getChildren()) {
	                Node childNode = edge.getEnd();
	                Node result = recursiveDLS(childNode, goal, limit - 1);
	                if (result == null) {
	                    // Cutoff occurred at this level
	                    cutoffOccurred = true;
	                } else if (!result.getLabel().equals("failure")) {
	                    // Goal or valid solution found, return it
	                    return result;
	                }
	            }

	            if (cutoffOccurred) {
	                // Cutoff occurred at this level
	                return null;
	            } else {
	                // No solution found at this level, return failure
	                return new Node("failure");
	            }
	        }
	    }

		@Override
		public Node execute(Node root, String goal) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Node execute(Node root, String start, String goal) {
			// TODO Auto-generated method stub
			return null;
		}
}
