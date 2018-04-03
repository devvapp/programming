import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycleDetection {
	private final ArrayList<Integer>[] graph;

	UndirectedGraphCycleDetection(ArrayList<Integer>[] graph) {
		this.graph = graph;
	}

	boolean hasCycle() {
		List<Integer> visited = new ArrayList<>();
		// We do not need the below loop as there are no unconnected nodes so
		// commented it
		// for (int i = 0; i < graph.length; ++i) {
		if (hasCycle(0, visited, -1)) {
			return true;
		}
		// }
		return false;
	}

	private boolean hasCycle(Integer node, List<Integer> visited, Integer parent) {
		visited.add(node);
		for (Integer nextNode : graph[node]) {
			if (!visited.contains(nextNode)) {
				if (hasCycle(nextNode, visited, node)) {
					return true;
				}
			} else if (nextNode != parent) {
				return true;
			}
		}
		return false;
	}

	void addEdge(int v, int w) {
		graph[v].add(w); // Add w to v’s list.
		graph[w].add(v);
	}

	public static void main(String[] args) {
		ArrayList<Integer>[] graph = new ArrayList[5];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		UndirectedGraphCycleDetection g1 = new UndirectedGraphCycleDetection(graph);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(1, 4);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		if (g1.hasCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}