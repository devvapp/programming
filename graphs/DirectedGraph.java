//package

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


/**
 * DirectedGraph
 */
public class DirectedGraph {

    public static void main(String[] args) {
        
            Map<String, LinkedList<String>> graph = new HashMap<>();
    
            DirectedGraph directedGraph = new DirectedGraph();
            directedGraph.addEdge(graph, "0", "1");
            directedGraph.addEdge(graph, "0", "2");
            directedGraph.addEdge(graph, "1", "2");
            directedGraph.addEdge(graph, "2", "0");
            directedGraph.addEdge(graph, "2", "3");
            directedGraph.addEdge(graph, "3", "3");
    
            directedGraph.printGraph(graph);
            
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