package Lab6_1;

public class Queen {
	private static final int N = 8;
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		row++;
		if (row == N) {
			row = 0;
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		int rowDiff = Math.abs(this.row - q.getRow());
		int colDiff = Math.abs(this.column - q.getColumn());
		return this.row == q.row || this.column == q.column || rowDiff == colDiff;

	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
