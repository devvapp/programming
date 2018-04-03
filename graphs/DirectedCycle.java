import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Better implementation of Directed graph cycle detection than DirectedCycleInAGraph.java as it checks every node.
 */
public class DirectedCycle {
	private final ArrayList<Integer>[] graph;

	DirectedCycle(ArrayList<Integer>[] graph) {
		this.graph = graph;
	}

	boolean hasCycle() {
		List<Integer> visited = new ArrayList<>();
		Set<Integer> marked = new HashSet<>();
		for (int i = 0; i < graph.length; ++i) {
			if (!marked.contains(i) && hasCycle(i, visited, marked)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCycle(int node, List<Integer> visited, Set<Integer> marked) {
		if (visited.contains(node)) {
			return true;
		}
		visited.add(node);
		marked.add(node);
		for (Integer nextNode : graph[node]) {
			if (hasCycle(nextNode, visited, marked)) {
				return true;
			}
		}
		visited.remove(visited.size() - 1);
		return false;
	}

	void addEdge(int v, int w) {
		graph[v].add(w); // Add w to v’s list.
	}

	public static void main(String[] args) {
		ArrayList<Integer>[] graph = new ArrayList[4];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		DirectedCycle directedCycle = new DirectedCycle(graph);
		directedCycle.addEdge(0, 1);
		directedCycle.addEdge(0, 2);
		directedCycle.addEdge(1, 2);
		directedCycle.addEdge(2, 0);
		directedCycle.addEdge(2, 3);
		directedCycle.addEdge(3, 3);

		if (directedCycle.hasCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}