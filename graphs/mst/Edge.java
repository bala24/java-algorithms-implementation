import java.util.Set;
import java.util.HashSet;

public class Edge implements Comparable<Edge>
{
  private int weight;
  private Node node1, node2;

  Edge(final Node node1, final Node node2, final int weight)
  {
    this.node1 = node1;
    this.node2 = node2;
    this.weight = weight;
  }  

  public int compareTo(Edge other)
  {
    return Integer.compare(this.weight, other.getWeight());
  }

  int getWeight()
  {
    return weight;
  }

  Node getNode1()
  {
    return node1;
  }

  Node getNode2()
  {
    return node2;
  }
}
