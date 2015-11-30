import java.util.List;
import java.util.Deque;
import java.util.Set;
import java.util.LinkedList;

public class BreadthFirstSearch
{
  public static void main(String args[]) 
  {
    // Initialize the graph
    final Graph graph = new Graph();
    final Node startNode = initializeGraph(graph);

    // BFS
    doBFS(graph, startNode);

    // Print to verify the distances from start
    final List<Node> nodes = graph.getVertices();
    for(Node node : nodes)
    {
      System.out.println("Node is '" + node.getLabel() + "' and dist is " + node.getDist());
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
    g.addEdge(nodes[0], nodes[1]);    
    g.addEdge(nodes[1], nodes[2]);    
    g.addEdge(nodes[2], nodes[3]);    
    g.addEdge(nodes[0], nodes[4]);    
    g.addEdge(nodes[1], nodes[5]);    
    g.addEdge(nodes[2], nodes[6]);    
    g.addEdge(nodes[3], nodes[7]);    

    return nodes[0];
  }

  /**
   * The implementation of BFS. 
   *
   * @param graph The graph
   * @param start The starting node for the graph
   */
  private static void doBFS(final Graph graph, final Node start)
  {
    // Initialize all the colors of the node as white 
    final List<Node> nodes = graph.getVertices();
    for(final Node node : nodes)
    {
      node.setColor('w');
      node.setParent(null);
      node.setDist(Integer.MAX_VALUE);
    }

    // Queue to store the visited nodes
    final Deque<Node> queue = new LinkedList<Node>();

    // Initialize the first node
    start.setColor('g');
    start.setDist(0);
    start.setParent(null);
    int dist = 0;
  
    queue.add(start);

    // Repeat until queue is not empty
    while(!queue.isEmpty())
    { 
      // Get the head node from queue and its neighbors
      final Node node = queue.getFirst(); 
      final Set<Node> neighbors = node.getNeighbors();
      for(final Node neighborNode : neighbors)
      {
        // If the node is 'unseen'
        if(neighborNode.getColor() == 'w')
        {
          // Mark it as 'seen'
          neighborNode.setColor('g');
          neighborNode.setParent(node);
          neighborNode.setDist(node.getDist() + 1);
  
          // Add it to the queue to be visited at a later point
          queue.add(neighborNode);
        }
      }

      // Mark this node as visited and remove it from queue
      node.setColor('b');
      queue.remove(node);
    }
  }
} 
