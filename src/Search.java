import java.util.*;

public class Search<V> {
    V source;
    Set<V> marked;
    Map<V, V> edgeTo;

    public Search(V source){
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V var){
        return marked.contains(var);
    }
    public Iterable<V> pathTo(V var){
        if (hasPathTo(var) == false){
            return null;
        }

        Stack<V> path = new Stack<>();
        for (V i = var; i != null; i = edgeTo.get(i)){
            path.push(i);
        }
        return path;
    }
}
