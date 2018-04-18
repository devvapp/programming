import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DegreeOfSeparation {

	class PathNode {

		private String key;
		private PathNode prevNode;

		public PathNode(String key, PathNode prevNode) {
			super();
			this.key = key;
			this.prevNode = prevNode;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public PathNode getPrevNode() {
			return prevNode;
		}
		public void setPrevNode(PathNode prevNode) {
			this.prevNode = prevNode;
		}

		public LinkedList<String> collapse(boolean startsWithRoot) {
			LinkedList<String> path = new LinkedList<String>();
			PathNode node = this;
			while (node != null) {
				if (startsWithRoot) {
					path.addLast(node.getKey());
				} else {
					path.addFirst(node.getKey());
				}
				node = node.prevNode;
			}
			return path;
		}

		@Override
		public String toString() {
			return "PathNode [key=" + key + ", prevNode=" + prevNode + "]";
		}

	}

	class BFSNode {

		private Map<String, PathNode> visited = new HashMap<>();
		private Queue<PathNode> toVisit = new LinkedList<>();

		public BFSNode(String key) {

			PathNode sourcePath = new PathNode(key, null);
			this.visited.put(key, sourcePath);
			this.toVisit.add(sourcePath);
		}

		public Map<String, PathNode> getVisited() {
			return visited;
		}

		public void setVisited(Map<String, PathNode> visited) {
			this.visited = visited;
		}

		public Queue<PathNode> getToVisit() {
			return toVisit;
		}

		public void setToVisit(Queue<PathNode> toVisit) {
			this.toVisit = toVisit;
		}

		@Override
		public String toString() {
			return "BFSNode [visited=" + visited + ", toVisit=" + toVisit + "]";
		}

	}

	public Map addEdge(Map<String, LinkedList<String>> graph, String src, String dest) {

		if (graph == null) {
			graph = new HashMap<String, LinkedList<String>>();
		}

		// Add an edge from src to dest
		LinkedList<String> srcAdjList = graph.get(src);
		if (srcAdjList == null) {
			srcAdjList = new LinkedList<String>();
			graph.put(src, srcAdjList);
		}
		if (!srcAdjList.contains(dest)) {
			srcAdjList.addFirst(dest);

			// As the graph is undirected, add an edge from dest to src also
			LinkedList destAdjList = graph.get(dest);
			if (destAdjList == null) {
				destAdjList = new LinkedList<String>();
				graph.put(dest, destAdjList);
			}
			destAdjList.addFirst(src);
		}

		return graph;
	}

	public LinkedList<String> findDegreeOfSeparation(String src, String dest) {

		BFSNode sNode = new BFSNode(src);
		BFSNode dNode = new BFSNode(dest);

		while (!sNode.getToVisit().isEmpty() && !dNode.getToVisit().isEmpty()) {
			String collisionPathNodeKey = getCollisionPathNode(sNode, dNode);
			if (collisionPathNodeKey != null) {
				System.out.println("Path Exists");
				return mergePaths(sNode, dNode, collisionPathNodeKey);
			}

			collisionPathNodeKey = getCollisionPathNode(dNode, sNode);
			if (collisionPathNodeKey != null) {
				System.out.println("Path Exists");
				return mergePaths(sNode, dNode, collisionPathNodeKey);
			}
		}
		System.out.println("Path Does not exist");
		return null;
	}

	public String getCollisionPathNode(BFSNode sNode, BFSNode dNode) {

		if (!sNode.getToVisit().isEmpty()) {
			PathNode path = sNode.getToVisit().poll();
			List<String> children = graph.get(path.getKey());

			if (dNode.getVisited().containsKey(path.getKey())) {
				return path.getKey();
			}

			for (String child : children) {
				if (!sNode.getVisited().containsKey(child)) {
					PathNode next = new PathNode(child, path);
					sNode.getVisited().put(child, next);
					sNode.getToVisit().add(next);
				}
			}
		}

		return null;
	}

	public static LinkedList<String> mergePaths(BFSNode bfs1, BFSNode bfs2, String connection) {
		PathNode end1 = bfs1.getVisited().get(connection); // end1 -> source
		PathNode end2 = bfs2.getVisited().get(connection); // end2 -> dest
		LinkedList<String> pathOne = end1.collapse(false); // forward: source ->
															// connection
		LinkedList<String> pathTwo = end2.collapse(true); // reverse: connection
															// -> dest
		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path
		return pathOne;
	}

	Map<String, LinkedList<String>> graph = new HashMap<>();

	public void init() {

		this.addEdge(graph, "0", "1");
		this.addEdge(graph, "0", "2");
		this.addEdge(graph, "0", "3");
		this.addEdge(graph, "1", "4");
		this.addEdge(graph, "2", "5");
		this.addEdge(graph, "3", "6");
		this.addEdge(graph, "4", "7");
		this.addEdge(graph, "5", "7");
		this.addEdge(graph, "6", "7");

	}

	public static void printPeople(LinkedList<String> path) {
		if (path == null) {
			System.out.println("No path");
		} else {
			for (String p : path) {
				System.out.print(p + " -> ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {

		DegreeOfSeparation undirectedGraph = new DegreeOfSeparation();
		undirectedGraph.init();
		LinkedList<String> findDegreeOfSeparation = undirectedGraph.findDegreeOfSeparation("0", "7");
		undirectedGraph.printPeople(findDegreeOfSeparation);

	}
}
