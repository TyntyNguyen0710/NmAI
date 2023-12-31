package Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> re = new ArrayList<>();

		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			for (int j = 1; j <= current / 2; j++) {
				if (j != current - j) {
					Node success = new Node();
					success.add(j);
					success.add(current - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i)
							success.add(data.get(k));
					}
					re.add(success);
					if (!re.contains(success))
						re.add(success);
				}
			}
		}
		return re;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		for (int i = 0; i < data.size(); i++) {
			for (int j = 1; j < data.size(); j++) {
				if (data.get(i) % data.get(j) == 0 || data.get(j) % data.get(i) == 0)
					return false;
			}
		}
		return true;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}
}
