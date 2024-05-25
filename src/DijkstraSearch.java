import java.util.HashMap;
import java.util.Map;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V source){
        super(source);
        for(V var : graph.getVertices()){
            distances.put(var, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        dijkstra(graph);
    }
    public void dijkstra(WeightedGraph<V> graph){
        while(true){
            V vertex = null;
            double minDistance = Double.POSITIVE_INFINITY;

            for (V var : distances.keySet()){
                if (marked.contains(var) == false && distances.get(var) < minDistance){
                    vertex = var;
                    minDistance = distances.get(var);
                }
            }

            if (vertex == null)
                break;

            marked.add(vertex);

            for (V var : graph.getAdjacentVertices(vertex)){
                if (marked.contains(var) == false){
                    double newDistance = distances.get(vertex) + graph.getWeight(vertex, var);
                    if (newDistance < distances.get(var)){
                        distances.put(var, newDistance);
                        edgeTo.put(var, vertex);
                    }
                }
            }
        }
    }
}
