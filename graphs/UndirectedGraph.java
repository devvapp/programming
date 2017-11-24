//package

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;


/**
 * UndirectedGraph
 */
public class UndirectedGraph {

    public static void main(String[] args) {

        Map<String, LinkedList<String>> graph = new HashMap<>();

        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addEdge(graph, "0", "1");
        undirectedGraph.addEdge(graph, "0", "4");
        undirectedGraph.addEdge(graph, "1", "2");
        undirectedGraph.addEdge(graph, "1", "3");
        undirectedGraph.addEdge(graph, "1", "4");
        undirectedGraph.addEdge(graph, "2", "3");
        undirectedGraph.addEdge(graph, "3", "4");

        undirectedGraph.printGraph(graph);
        
    }

    public Map addEdge(Map<String, LinkedList<String>> graph, String src, String dest){

        if(graph == null){
            graph = new HashMap<String, LinkedList<String>>();
    }   

        // Add an edge from src to dest
        LinkedList<String> srcAdjList = graph.get(src);
        if(srcAdjList == null){
            srcAdjList = new LinkedList<String>();
            graph.put(src, srcAdjList);
        }
        if(!srcAdjList.contains(dest)){
            srcAdjList.addFirst(dest);

            // As the graph is undirected, add an edge from dest to src also
            LinkedList destAdjList = graph.get(dest);
            if(destAdjList == null){
                destAdjList = new LinkedList<String>();
                graph.put(dest, destAdjList);
            }
            destAdjList.addFirst(src);
        }

        return graph;
    }

    public void printGraph(Map graph){

        Iterator iterator = graph.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String key = (String)entry.getKey();
            LinkedList<String> values = (LinkedList<String>)entry.getValue();
            System.out.print(key + " - ");
            for(String value : values){
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
    
}