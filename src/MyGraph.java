public class MyGraph<V> extends WeightedGraph<V>{
    public MyGraph(boolean directed){
        super(directed);
    }
    public void addEdge(V source, V destination){
        super.addEdge(source, destination,1.0 );
    }
}
