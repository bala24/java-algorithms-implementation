import java.util.Set;
import java.util.HashSet;

public class Node
{
  private char label;
  private Node parent;

  final Set<Node> adj = new HashSet<Node>();

  Node (char label)
  {
    this.label = label;
  }
  
  public Node getParent()
  {
    return parent;
  }

  public void setParent(final Node parent)
  {
    this.parent = parent;
  }

  public char getLabel()
  {
    return label;
  }
 
  public void addEdgeTo(final Node dest)
  {
    adj.add(dest);
  }

  public Set<Node> getNeighbors()
  {
    return adj;
  }
}

