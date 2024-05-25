import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<V, Vertex<V>> map = new HashMap<>();
    public WeightedGraph(boolean directed){
        this.directed = directed;
    }
    public WeightedGraph(){
        this(false);
    }

    public void addVertex(V data){
        map.put(data, new Vertex<>(data));
    }
    public void addEdge(V source, V destination, Double weight) {
        if (map.containsKey(source) == false)
            addVertex(source);
        if (map.containsKey(destination) == false)
            addVertex(destination);
        map.get(source).addAdjacentVertex(map.get(destination), weight);
        if (directed == false)
            map.get(destination).addAdjacentVertex(map.get(source), weight);
    }

    public boolean hasVertex(V data){
        return map.containsKey(data);
    }
    public Vertex<V> getVertex(V data){
        return map.get(data);
    }

    public boolean hasEdge(V source, V destination){
        if (hasVertex(source) == false)
            return false;
        if (hasVertex(destination) == false)
            return false;
        return map.get(source).getAdjacentVertices().containsKey(map.get(destination));
    }
    public Double getWeight(V source, V destination){
        if (hasEdge(source, destination) == false)
            return Double.POSITIVE_INFINITY;
        return map.get(source).getAdjacentVertices().get(map.get(destination));
    }

    public Iterable<V> getVertices(){
        return map.keySet();
    }
}
