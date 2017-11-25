//package
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Integer;

/**
 * DjistrasShortestPath
 */
public class DijkstrasShortestPath {


    public static void main(String[] args) {
        WeightedUndirectedGraphBuilder weightedUndirectedGraphBuilder = new WeightedUndirectedGraphBuilder();
        Map<String, LinkedList<WeightedUndirectedGraphBuilder.Node>> graph = new HashMap<>();
        weightedUndirectedGraphBuilder.addEdge(graph, "0", "1", 4);
        weightedUndirectedGraphBuilder.addEdge(graph, "0", "7", 8);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "0", 4);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "7", 11);
        weightedUndirectedGraphBuilder.addEdge(graph, "1", "2", 8);
        weightedUndirectedGraphBuilder.addEdge(graph, "2", "1", 8);
        weightedUndirectedGraphBuilder.addEdge(graph, "2", "8", 2);
        weightedUndirectedGraphBuilder.addEdge(graph, "2", "3", 7);
        weightedUndirectedGraphBuilder.addEdge(graph, "2", "5", 4);
        weightedUndirectedGraphBuilder.addEdge(graph, "3", "2", 7);
        weightedUndirectedGraphBuilder.addEdge(graph, "3", "5", 14);
        weightedUndirectedGraphBuilder.addEdge(graph, "3", "4", 9);
        weightedUndirectedGraphBuilder.addEdge(graph, "4", "3", 9);
        weightedUndirectedGraphBuilder.addEdge(graph, "4", "5", 10);
        weightedUndirectedGraphBuilder.addEdge(graph, "5", "2", 4);
        weightedUndirectedGraphBuilder.addEdge(graph, "5", "3", 14);
        weightedUndirectedGraphBuilder.addEdge(graph, "5", "4", 10);
        weightedUndirectedGraphBuilder.addEdge(graph, "5", "6", 2);
        weightedUndirectedGraphBuilder.addEdge(graph, "6", "5", 2);
        weightedUndirectedGraphBuilder.addEdge(graph, "6", "7", 1);
        weightedUndirectedGraphBuilder.addEdge(graph, "6", "8", 6);
        weightedUndirectedGraphBuilder.addEdge(graph, "7", "0", 8);
        weightedUndirectedGraphBuilder.addEdge(graph, "7", "1", 11);
        weightedUndirectedGraphBuilder.addEdge(graph, "7", "6", 1);
        weightedUndirectedGraphBuilder.addEdge(graph, "7", "8", 7);
        weightedUndirectedGraphBuilder.addEdge(graph, "8", "2", 2);
        weightedUndirectedGraphBuilder.addEdge(graph, "8", "6", 6);
        weightedUndirectedGraphBuilder.addEdge(graph, "8", "7", 7);
        
        DijkstrasShortestPath dsp = new DijkstrasShortestPath();
        dsp.dijkstrasShortestPath(graph, "0");
    }



    /**
     * Djistras algorithm to calculate the shortest paths between src and other nodes.
     */
    public void dijkstrasShortestPath(Map<String, LinkedList<WeightedUndirectedGraphBuilder.Node>> graph, String src){

        //Visited Array with all false values
        Map<String, Boolean> visited = new HashMap<>(graph.size());

        //Distance array with max of Integers
        Map<String, Integer> dArr = new HashMap<>(graph.size());
        
        //Populate the default values
        for(Map.Entry<String,LinkedList<WeightedUndirectedGraphBuilder.Node>>  entry : graph.entrySet()){
            //Initialize distance array to Max of integer value
            dArr.put(entry.getKey(), Integer.MAX_VALUE);

            //Initialize visited array to false
            visited.put(entry.getKey(), false);
        }

        dArr.put(src,0);

        String minKey = minKeyOfAnUnVisitedArray(dArr, visited);
        while( minKey != null){
            LinkedList<WeightedUndirectedGraphBuilder.Node> nodeList = graph.get(minKey);
            visited.put(minKey, true);
            for(WeightedUndirectedGraphBuilder.Node node : nodeList){
                if(dArr.get(minKey)+node.weight < dArr.get(node.key)){
                    dArr.put(node.key, dArr.get(minKey) + node.weight);
                }
            }
            minKey = minKeyOfAnUnVisitedArray(dArr, visited);
        }


        for(Map.Entry<String,Integer> entry : dArr.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue() + " - " + visited.get(entry.getKey()));
        }

    }


    /**
     * Get the minimum distance index value of an unvisited key
     */
    public String minKeyOfAnUnVisitedArray(Map<String, Integer> dArr, Map<String, Boolean> visited){

        int min = Integer.MAX_VALUE;
        String minKey = null;

        for(Map.Entry<String,Integer> entry : dArr.entrySet()){
            String key = entry.getKey();
            if( !visited.get(key) && entry.getValue() < min){
                min = entry.getValue();
                minKey = entry.getKey();
            }
        }
        return minKey;
    }
    
}