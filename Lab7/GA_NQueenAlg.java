package Lab7;

import java.util.*;

public class GA_NQueenAlg {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 10;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute(int k) {
		int iteration = 0;
		while (iteration < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByTournamentSelection(k);
				Node y = getParentByTournamentSelection(k);
				Node child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				newPopulation.add(child);
			}
			population = newPopulation;
			iteration++;
		}
		return getBestIndividual();
	}

	private Node getBestIndividual() {
		Node best = population.get(0);
		for (Node individual : population) {
			if (individual.getH() < best.getH()) {
				best = individual;
			}
		}
		return best;
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		int queenRd = rd.nextInt(Node.N);
		int newRow = rd.nextInt(Node.N);
		node.setRow(queenRd, newRow);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node();
		child.generateBoard();
		
		for (int i = 0; i < rd.nextInt(Node.N); i++) {
			child.setRow(i, x.getRow(i));
		}
		for (int i = rd.nextInt(Node.N); i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		Node best = null;

		for (int i = 0; i < k; i++) {
			Node candidate = population.get(rd.nextInt(POP_SIZE));

			if (best == null || candidate.getH() < best.getH()) {
				best = candidate;
			}
		}
		return best;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		return population.get(rd.nextInt(POP_SIZE));
	}
}
