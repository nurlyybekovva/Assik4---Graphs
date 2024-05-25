import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, V source){
        Queue<V> q = new LinkedList<>();
        q.add(source);
        marked.add(source);

        while (q.isEmpty() == false) {
            V var = q.poll();
            for (Vertex<V> vertex : graph.getVertex(var).getAdjacentVertices().keySet()) {
                if (marked.contains(vertex.getData()) == false) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), var);
                    q.add(vertex.getData());
                }
            }
        }
    }
}
