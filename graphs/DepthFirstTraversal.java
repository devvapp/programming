//package

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * DepthFirstTraversal of a directed graph
 */
public class DepthFirstTraversal {

    public static void main(String[] args) {

        DirectedGraph directedGraph = new DirectedGraph();

        Map<String, LinkedList<String>> graph = new HashMap<>();

        directedGraph.addEdge(graph, "0", "1");
        directedGraph.addEdge(graph, "0", "2");
        directedGraph.addEdge(graph, "1", "2");
        directedGraph.addEdge(graph, "2", "3");
        directedGraph.addEdge(graph, "2", "0");
        directedGraph.addEdge(graph, "3", "3");
        directedGraph.addEdge(graph, "4", "5");

        DepthFirstTraversal  depthFirstTraversal = new DepthFirstTraversal();
        Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();
        depthFirstTraversal.dfsTraversal(graph, "2", visitedMap);
        System.out.println();
    }


    /**
     * Depth first traversal
     */
    public void dfsTraversal(Map<String, LinkedList<String>> graph, String start, Map<String, Boolean> visitedMap){
        
        visitedMap.put(start, true);
        System.out.print(start + " ");

        LinkedList<String> adjList = graph.get(start);
        if(adjList != null){
            for(String key : adjList){
                if(visitedMap.get(key) == null){
                    dfsTraversal(graph, key, visitedMap);
                }
            }
        }
    }
}