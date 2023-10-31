package goal;

public class main {
	public static void main(String[] args) {
		// data task1,2,3
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);

//		// BFS
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//
//		Node result = algo1.execute(nodeS, "G");
//		System.out.println(NodeUtils.printPath(result));

//		Node result = algo1.execute(nodeS, "G", "A");
//		System.out.println(NodeUtils.printPath(result));

		// DFS
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result = algo2.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result));	

		// UCS
//		ISearchAlgo ucs = new UniformCostSearchAlgo();
//		Node result = ucs.execute(nodeS, "G");
//		System.out.println(NodeUtils.printPath(result));

		// data4,5
//		Node nodeStart = new Node("Start");
//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeF = new Node("F");
//		Node nodeR = new Node("R");
//		Node nodeP = new Node("P");
//		Node nodeQ = new Node("Q");
//		Node nodeH = new Node("H");
//		Node nodeGoal = new Node("Goal");
//		nodeStart.addEdge(nodeP, 1);
//		nodeStart.addEdge(nodeD, 3);
//		nodeStart.addEdge(nodeE, 9);
//		nodeD.addEdge(nodeB, 1);
//		nodeD.addEdge(nodeE, 2);
//		nodeD.addEdge(nodeC, 8);
//		nodeB.addEdge(nodeA, 2);
//		nodeC.addEdge(nodeA, 2);
//		nodeP.addEdge(nodeQ, 15);
//		nodeE.addEdge(nodeH, 1);
//		nodeH.addEdge(nodeP, 4);
//		nodeH.addEdge(nodeQ, 4);
//		nodeQ.addEdge(nodeR, 3);
//		nodeE.addEdge(nodeR, 9);
//		nodeE.addEdge(nodeH, 1);
//		nodeR.addEdge(nodeF, 5);
//		nodeF.addEdge(nodeC, 5);
//		nodeF.addEdge(nodeGoal, 5);
//		ISearchAlgo algo3 = new UniformCostSearchAlgo();
//		
//		 Node result = algo3.execute(nodeStart, "Goal");
//			System.out.println(NodeUtils.printPath(result));	
//		Node result = algo3.execute(nodeStart, "Start", "Goal");
//		System.out.println(NodeUtils.printPath(result));
	}
}
