package goal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {
				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<String>();
	}

}
