//package

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * DetectCycleInAGraph - May be incorrect. Please refer the new implementation DirectedCycle.java
 */
public class DetectCycleInAGraph {


    
    public static void main(String[] args) {
        

        DirectedGraph directedGraphBuilder = new DirectedGraph();
        Map<String, LinkedList<String>> directedGraph = new HashMap<>();
        directedGraphBuilder.addEdge(directedGraph, "0", "1");
        directedGraphBuilder.addEdge(directedGraph, "0", "2");
        directedGraphBuilder.addEdge(directedGraph, "1", "2");
        directedGraphBuilder.addEdge(directedGraph, "2", "3");
        //directedGraphBuilder.addEdge(directedGraph, "2", "0");
        directedGraphBuilder.addEdge(directedGraph, "3", "3");
        directedGraphBuilder.addEdge(directedGraph, "4", "5");


        DetectCycleInAGraph detectCycleInAGraph = new DetectCycleInAGraph();
        Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();

        System.out.println("DetectCycleInADirectedGraph - " + detectCycleInAGraph.detectCycleInADirectedGraph(directedGraph, "2", visitedMap));
        
    }

    /**
     * Detect cycles in a directed graph. This will use DFS traversal algorigthm
     */
    public boolean detectCycleInADirectedGraph(Map<String, LinkedList<String>> graph, String start, Map<String, Boolean> visitedMap){

        LinkedList<String> adjList = graph.get(start);

        visitedMap.put(start, true);

        if(adjList != null){
            for(String key : adjList){
                if(visitedMap.get(key) == null){
                    return detectCycleInADirectedGraph(graph, key, visitedMap);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}