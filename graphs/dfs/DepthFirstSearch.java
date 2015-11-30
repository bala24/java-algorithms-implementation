import java.util.List;
import java.util.Deque;
import java.util.Set;
import java.util.LinkedList;

public class DepthFirstSearch
{
  private static int time = 0;
  public static void main(String args[]) 
  {
    // Initialize the graph
    final Graph graph = new Graph();
    final Node startNode = initializeGraph(graph);

    // DFS
    doDFS(graph, startNode);

    // Print to verify the time of discovery vs finished processing the node
    final List<Node> nodes = graph.getVertices();
    for(Node node : nodes)
    {
      System.out.println("Node is '" + node.getLabel() + 
                         "' - disc time is " + node.getTimeDiscovered() + 
                         " / fin time is " + node.getTimeFinished());
    }

  }

  private static Node initializeGraph(final Graph g)
  {
    // List of nodes
    Node nodes[] = new Node[] { new Node('a'), new Node('b'), new Node('c'), new Node('d'),
                                new Node('e'), new Node('f'), new Node('g'), new Node('h')};

    // Add each node to the graph
    for(Node node : nodes)
    {
      g.addNode(node);
    }

    // Add the edges
    // a -> b -> c -> d
    // |    |    |    |
    // v    v    v    v
    // e -> f    g -> h
    g.addEdge(nodes[0], nodes[1]);    
    g.addEdge(nodes[1], nodes[2]);    
    g.addEdge(nodes[2], nodes[3]);    
    g.addEdge(nodes[0], nodes[4]);    
    g.addEdge(nodes[1], nodes[5]);    
    g.addEdge(nodes[2], nodes[6]);    
    g.addEdge(nodes[3], nodes[7]);    
    g.addEdge(nodes[4], nodes[5]);    
    g.addEdge(nodes[6], nodes[7]);    

    return nodes[0];
  }

  /**
   * Implementation of DFS. 
   *
   * @param graph The graph
   * @param start The starting node for the graph
   */
  private static void doDFS(final Graph graph, final Node start)
  {
    // Initialize all the colors of the node as white 
    final List<Node> nodes = graph.getVertices();
    for(final Node node : nodes)
    {
      node.setColor('w');
      node.setParent(null);
    }

    // For every node that is white, search depth first
    for(final Node node : nodes)
    {
      if(node.getColor() == 'w')
      { 
        node.setParent(null);
        node.setColor('g');
        node.setTimeDiscovered(time++);
        dfsVisit(node);
      }
    }
  }

  /**
   * Recursive call to all neighbors of node
   */
  private static void dfsVisit(final Node node)
  {
    for(final Node neighborNode : node.getNeighbors())
    {
      // If the node is 'unseen'
      if(neighborNode.getColor() == 'w')
      {
        // Mark it as 'seen'
        neighborNode.setColor('g');
        neighborNode.setParent(node);
        neighborNode.setTimeDiscovered(time++);
  
        // Recursively call thus preserving the node in the current stack
        dfsVisit(neighborNode);
      }
    }

    // Mark this node as visited and register the finished time
    node.setColor('b');
    node.setTimeFinished(time++);
  }
} 
