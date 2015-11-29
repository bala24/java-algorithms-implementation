import java.util.Set;
import java.util.HashSet;

public class Node
{
  private char label;
  private char color;
  private Node parent;
  private int dist = Integer.MAX_VALUE;

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

  public int getDist()
  {
    return dist;
  }

  public void setDist(final int dist)
  {
    this.dist = dist;
  }

  public char getColor()
  {
    return color;
  }

  public void setColor(final char color)
  {
    this.color = color;
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

