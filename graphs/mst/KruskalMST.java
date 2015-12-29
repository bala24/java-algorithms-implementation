import java.util.List;
import java.util.Deque;
import java.util.Set;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class KruskalMST
{
  public static void main(String args[]) 
  {
    // Initialize the graph
    final Graph graph = new Graph();
    final Node rootNode = initializeGraph(graph);

    // MST
    Set<Edge> mstEdges = getMST(graph);

    //for(Edge edge: graph.getEdges())
    for(Edge edge: mstEdges)
    {
      System.out.println("Edge between " + edge.getNode1().getLabel() + 
                         " and " + edge.getNode2().getLabel() + 
                         " with a weight of " + edge.getWeight());
    }

  }

  private static Node initializeGraph(final Graph g)
  {
    Node a = new Node('a'); Node b = new Node('b'); Node c = new Node('c'); 
    Node d = new Node('d'); Node e = new Node('e'); Node f = new Node('f');
    Node gNode = new Node('g'); Node h = new Node('h');
   
    // List of nodes
    Node nodes[] = new Node[] { a, b, c, d, e, f, gNode, h};

    // Add each node to the graph
    for(Node node : nodes)
    {
      g.addNode(node);
    }

    // Add the edges
    //     8      9     2
    //  a --- b ---- c --- d
    // 5| 4/ 6| 2X3 4|  \6 |3
    //  e --- f ---- g --- h
    //     1      7     1
    
    g.addEdge(a, b, 8);
    g.addEdge(a, e, 5);
    g.addEdge(b, e, 4);
    g.addEdge(b, f, 6);
    g.addEdge(b, c, 9);
    g.addEdge(b, gNode, 3);
    g.addEdge(e, f, 1);
    g.addEdge(f, gNode, 7);
    g.addEdge(f, c, 2);
    g.addEdge(c, gNode, 4);
    g.addEdge(c, d, 2);
    g.addEdge(c, h, 6);
    g.addEdge(d, h, 3);
    g.addEdge(gNode, h, 1);

    Collections.sort(g.getEdges());     

    return nodes[0];
  }

  /**
   * Implementation of Kruskal Minimal Spanning Tree. 
   *
   * @param graph The graph
   * @param root The root node for the graph
   */
  private static Set<Edge> getMST(final Graph graph)
  { 
    Set<Edge> mst = new HashSet<Edge>();
    
    // A = Null
    // for each vertex put the vertex in its own set
    // 
    // Sort each of the edges in non-descending order
    //
    // for each of the edge u,v in E
    //   if FIND(u) != FIND(v)
    //      A = A + u,e
    //      UNION(u, v)
    //
    //  return A
    List<Node> nodes = graph.getVertices();
    
    Hashtable<Node, Node> nodeToRepNode = new Hashtable<Node, Node>();
    Hashtable<Node, Set<Node>> nodeToNodeSet = new Hashtable<Node, Set<Node>>();

    for(Node node : nodes)
    {
      nodeToRepNode.put(node, node);
      nodeToNodeSet.put(node, new HashSet<Node>(Arrays.asList(node)));
    }

    for(Edge edge : graph.getEdges())
    {
      //System.out.println("Edge " + edge.getNode1().getLabel() + "-" + edge.getWeight() + "-" + edge.getNode2().getLabel());
      if(nodeToRepNode.get(edge.getNode1()) != nodeToRepNode.get(edge.getNode2()))
      {
        //System.out.println("Edge " + nodeToRepNode.get(edge.getNode1()).getLabel() 
        //                   + "   " + nodeToRepNode.get(edge.getNode2()).getLabel());
        //System.out.println(nodeToRepNode.get(edge.getNode1()) + " " + nodeToRepNode.get(edge.getNode2()));

        mst.add(edge);
        Set<Node> node1Set = nodeToNodeSet.get(edge.getNode1());
        Set<Node> node2Set = nodeToNodeSet.get(edge.getNode2());
        node1Set.addAll(node2Set);
        for(Node node : nodeToNodeSet.get(edge.getNode1()))
        {
          nodeToNodeSet.put(node, node1Set);
        }
        for(Node node : nodeToNodeSet.get(edge.getNode2()))
        {  
          nodeToRepNode.put(node, nodeToRepNode.get(edge.getNode1()));
        }
      }
    }

    return mst;
  }
}
