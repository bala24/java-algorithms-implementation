import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Graph
{
  private List<Node> vertices;
  private int nodeCount = 0;

  public Graph()
  {
    vertices = new ArrayList<Node>();
  }

  public void addNode(Node node)
  {
    vertices.add(node);
  }
    
  public void addEdge(Node source, Node dest)
  {
    source.addEdgeTo(dest);
    dest.addEdgeTo(source);
  }

  public List<Node> getVertices()
  {
    return vertices;
  }
}
