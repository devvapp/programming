//package

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

/**
 * BreadthFirstTraversal
 */
public class BreadthFirstTraversal {




    public static void main(String[] args) {

        DirectedGraph directedGraph = new DirectedGraph();

        Map<String, LinkedList<String>> graph = new HashMap<>();

        directedGraph.addEdge(graph, "0", "1");
        directedGraph.addEdge(graph, "0", "2");
        directedGraph.addEdge(graph, "1", "2");
        directedGraph.addEdge(graph, "2", "0");
        directedGraph.addEdge(graph, "2", "3");
        directedGraph.addEdge(graph, "3", "3");

        directedGraph.addEdge(graph, "4", "5");

        BreadthFirstTraversal  breadthFirstTraversal = new BreadthFirstTraversal();

        breadthFirstTraversal.bfsTraversal(graph, "1");

    }


    public void bfsTraversal(Map<String, LinkedList<String>> graph, String start){
        Queue<String> queue = new LinkedList<String>();

        //LinkedList<String> adjList = (LinkedList<String>) graph.get(start);
        Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();
        queue.add(start);

        while(queue.peek() != null){
            String key = queue.poll();
            visitedMap.put(key, true);
            System.out.print(key + " ");
            LinkedList<String> adjList = (LinkedList<String>) graph.get(key);
            if(adjList!=null){
                for(String adj : adjList){
                    if(visitedMap.get(adj) == null){
                        queue.add(adj);
                    }
                }
            }

        }

        System.out.println();
    }
}