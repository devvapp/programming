//package

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * WeightedUndirectedGraphBuilder
 */
public class WeightedUndirectedGraphBuilder {

    public class Node{
        String key;
        int weight;
        Node next;

        public Node(String key, int weight){
            this.key = key;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        Map<String, LinkedList<Node>> graph = new HashMap<>();

        WeightedUndirectedGraphBuilder weightedUndirectedGraphBuilder = new WeightedUndirectedGraphBuilder();
        weightedUndirectedGraphBuilder.addEdge(graph, "0", "1", 1);
        weightedUndirectedGraphBuilder.addEdge(graph, "0", "4", 2);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "2", 3);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "3", 4);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "4", 5);
        weightedUndirectedGraphBuilder.addEdge(graph, "2", "3", 6);
        weightedUndirectedGraphBuilder.addEdge(graph, "3", "4", 7);

        weightedUndirectedGraphBuilder.printGraph(graph);
        
    }

    public Map addEdge(Map<String, LinkedList<Node>> graph, String src, String dest, int weight){

        if(graph == null){
            graph = new HashMap<String, LinkedList<Node>>();
        }   

        // Add an edge from src to dest
        LinkedList<Node> srcAdjList = graph.get(src);
        if(srcAdjList == null){
            srcAdjList = new LinkedList<Node>();
            graph.put(src, srcAdjList);
        }
        if(!contains(srcAdjList, dest)){
            Node destNode = new Node(dest, weight);
            srcAdjList.addFirst(destNode);

            // As the graph is undirected, add an edge from dest to src also
            LinkedList destAdjList = graph.get(dest);
            if(destAdjList == null){
                destAdjList = new LinkedList<Node>();
                graph.put(dest, destAdjList);
            }
            Node srcNode = new Node(src, weight);
            destAdjList.addFirst(srcNode);

        }

        return graph;
    }

    public boolean contains(LinkedList<Node> list, String key){
        for(Node node : list){
            if(node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public void printGraph(Map graph){

        Iterator iterator = graph.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String key = (String)entry.getKey();
            LinkedList<Node> values = (LinkedList<Node>)entry.getValue();
            System.out.print(key + " -> ");
            for(Node node : values){
                System.out.print(" ("+node.key + ", "+ node.weight + ") ");
            }
            System.out.println();
        }

    }
}