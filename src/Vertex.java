import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> map = new HashMap<>(); // with weights

    public Vertex(V data){
        this.data = data;
    }
    public Vertex(){
        this(null);
    }
    public void setData(V data){
        this.data = data;
    }
    public V getData(){
        return data;
    }
    public void addAdjacentVertex(Vertex<V> destination, Double weight){
        map.put(destination, weight);
    }
    public Map<Vertex<V>, Double> getAdjacentVertices(){
        return map;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vertex<?> othVertex = (Vertex<?>) obj;
        return equals(othVertex.data);
    }
}
