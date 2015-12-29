import java.util.ArrayList;
import java.util.List;

public class Graph
{
  private List<Node> vertices;
  private List<Edge> edges;
  private int nodeCount = 0;

  public Graph()
  {
    vertices = new ArrayList<Node>();
    edges = new ArrayList<Edge>();
  }

  public void addNode(Node node)
  {
    vertices.add(node);
  }
    
  public void addEdge(Node source, Node dest, int weight)
  {
    Edge edge = new Edge(source, dest, weight);
    edges.add(edge);
    source.addEdgeTo(dest);
    dest.addEdgeTo(source);
  }

  public List<Node> getVertices()
  {
    return vertices;
  }

  public List<Edge> getEdges()
  {
    return edges;
  }
}
