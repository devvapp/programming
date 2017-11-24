//package

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;


/**
 * GraphRepresentation
 */
public class GraphRepresentation {

    public static void main(String[] args) {

        Map<String, LinkedList<String>> graph = new HashMap<>();

        GraphRepresentation graphRepresentation = new GraphRepresentation();
        graphRepresentation.addEdge(graph, "0", "1");
        graphRepresentation.addEdge(graph, "0", "4");
        graphRepresentation.addEdge(graph, "1", "2");
        graphRepresentation.addEdge(graph, "1", "3");
        graphRepresentation.addEdge(graph, "1", "4");
        graphRepresentation.addEdge(graph, "2", "3");
        graphRepresentation.addEdge(graph, "3", "4");

        graphRepresentation.printGraph(graph);
        
    }

    public Map addEdge(Map<String, LinkedList<String>> graph, String src, String dest){

        if(graph == null){
            graph = new HashMap<String, LinkedList<String>>();
        }

        LinkedList<String> srcAdjList = graph.get(src);
        if(srcAdjList == null){
            srcAdjList = new LinkedList<String>();
            graph.put(src, srcAdjList);
        }
        if(!srcAdjList.contains(dest)){
            srcAdjList.addFirst(dest);
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