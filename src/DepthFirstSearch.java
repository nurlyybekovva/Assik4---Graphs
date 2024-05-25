public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(MyGraph<V> graph, V source){
        super(source);
        dfs(graph, source);
    }
    private void dfs(MyGraph<V> graph, V source){
        marked.add(source);

        for (V var : graph.getVertex(source).getAdjacentVerticesData()){
            if (marked.contains(var) == false){
                edgeTo.put(var, source);
                dfs(graph, var);
            }
        }
    }
}
