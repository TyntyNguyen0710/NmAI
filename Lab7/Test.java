package Lab7;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		GA_NQueenAlg gaNQueenAlgo = new GA_NQueenAlg();
		gaNQueenAlgo.initPopulation();

		System.out.println("Initial Population:");
		displayPopulation(gaNQueenAlgo.population);

		Node solution = gaNQueenAlgo.execute(100);

		System.out.println("\nSolution:");
		solution.displayBoard();
	}

	private static void displayPopulation(List<Node> population) {
		for (int i = 0; i < population.size(); i++) {
			System.out.println("Individual " + (i + 1) + ":");
			population.get(i).displayBoard();
			System.out.println("Heuristic: " + population.get(i).getH());
			System.out.println();
		}
	}
}
