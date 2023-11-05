package Lab5;

import java.util.Arrays;

public class Node {
	private String label;
	private Node parent;
	private int[][] state;
	private int h;
	private int g;

	public Node(int row, int col) {
		this.setState(new int[row][col]);
		
	}

	/**
	 * @param label
	 * @param parent
	 * @param state
	 * @param h
	 * @param g
	 */
	

	// Copy a node
	public Node(Node node) {
		this.setState(new int[node.getState().length][node.getState()[0].length]);
		for (int i = 0; i < node.getState().length; i++) {
			for (int j = 0; j < node.getState()[i].length; j++) {
				getState()[i][j] = node.getState()[i][j];
			}
		}
	}

	public int getG() {
		return this.g;
	}

	public int getF() {
		return this.g + this.h;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getRow() {
		return this.getState().length;
	}

	public int getColumn() {
		return this.getState()[0].length;
	}

	// Get the location of a tile in the board
	public int[] getLocation(int tile) {
		int[] result = new int[2];
		for (int i = 0; i < this.getState().length; i++) {
			for (int j = 0; j < this.getState()[i].length; j++) {
				if (this.getState()[i][j] == tile) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	// Update the position of a tile
	public void updateTile(int row, int col, int value) {
		this.getState()[row][col] = value;
	}

	public int getTile(int row, int column) {
		return this.getState()[row][column];
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else {
			Node that = (Node) obj;
			return Arrays.deepEquals(this.getState(), that.getState());
		}
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < getState().length; i++) {
			for (int j = 0; j < getState()[i].length; j++) {
				output.append(getState()[i][j] + " ");
			}
			output.append("\n");
		}

		return output.toString();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int[][] getState() {
		return state;
	}

	public void setState(int[][] state) {
		this.state = state;
	}

}
