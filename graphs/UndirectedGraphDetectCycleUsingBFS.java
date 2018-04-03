import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphDetectCycleUsingBFS {

	private final ArrayList<Integer>[] graph;

	UndirectedGraphDetectCycleUsingBFS(ArrayList<Integer>[] graph) {
		this.graph = graph;
	}

	public boolean hasCycle() {
		return isCyclic(5);
	}

	public Boolean isCyclic(int V) {
		// parent array indicates if the vertex is visited
		// and if visited it store the parent of the vertex
		int[] parent = new int[V];
		// -1 indicates not visited
		Arrays.fill(parent, -1);
		// incase if graph has different connected components uncomment below
		//for (int i = 0; i < V; i++) {
			//if (parent[0] != -1)
			//	continue;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			// since i is the root of the bfs tree it doesn't have any parent
			// and to avoid -1 conflict make itself as its parent
			parent[0] = 0;
			while (!q.isEmpty()) {
				int src = q.poll();
				for (int adj : graph[src]) {
					// if vertex has edges to itself or
					// if adjacent vertex has been visited and its not the
					// parent
					// to the src
					if (adj == src || (parent[adj] != -1 && parent[src] != adj))
						return true;
					// if adjacent vertex is parent to the src
					if (parent[src] == adj)
						continue;
					// make the src parent to the adjacent vertex
					parent[adj] = src;
					q.add(adj);
				}
			}
		//}
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

		UndirectedGraphDetectCycleUsingBFS g1 = new UndirectedGraphDetectCycleUsingBFS(graph);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(0, 4);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		if (g1.hasCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

}
