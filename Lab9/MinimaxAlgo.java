package Lab9;

import java.util.Collections;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return 0; // Return utility value if the node is a terminal node
		}
		int v = Integer.MIN_VALUE;

		for (Node successor : node.getSuccessors()) {
			v = Math.max(v, minValue(successor));
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if (node.isTerminal()) {
			return 1; // Return utility value if the node is a terminal node
		}
		int v = Integer.MAX_VALUE;

		for (Node successor : node.getSuccessors()) {
			v = Math.min(v, maxValue(successor));
		}
		return v;
	}
}
