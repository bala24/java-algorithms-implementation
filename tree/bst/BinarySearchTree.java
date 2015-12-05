public class BinarySearchTree
{
  private Node root;

  /**
   * Insert a node into the tree
   *
   * @param node The node to insert.
   */
  public void insertNode(final Node node)
  {
    if(root == null)
    {
      root = node;
      return;
    }
    insertNode(root, node);
  }

  private void insertNode(final Node currentNode, final Node node)
  {
    if(currentNode.getPayload() == node.getPayload())
    {
      // Duplicates are not allowed in BSTs. Dont insert.
      return;
    }

    if(node.getPayload() > currentNode.getPayload()) 
    {
      // Try inserting into left node if possible.
      if(currentNode.getLeftNode() == null)
      {
        currentNode.setLeftNode(node);
        return;
      }
      else
      {
        // Recursive call
        insertNode(currentNode.getLeftNode(), node);
      }
    }
    else
    {
      // Try inserting into right node if possible.
      if(currentNode.getRightNode() == null)
      {
        currentNode.setRightNode(node);
        return;
      }
      else
      {
        // Recursive call
        insertNode(currentNode.getRightNode(), node);
      }
    }
  } 

  public void preOrderTraversal()
  {
    printPreOrderTraversal(root);
  }

  private void printPreOrderTraversal(Node node)
  {
    if(node == null)
    {
      return;
    }

    System.out.println(node.getPayload());
    printPreOrderTraversal(node.getRightNode());
    printPreOrderTraversal(node.getLeftNode());
  } 

  public void inOrderTraversal()
  {
    printInOrderTraversal(root);
  }

  private void printInOrderTraversal(Node node)
  {
    if(node == null)
    {
      return;
    }

    printInOrderTraversal(node.getRightNode());
    System.out.println(node.getPayload());
    printInOrderTraversal(node.getLeftNode());
  }

  public void postOrderTraversal()
  {
    printPostOrderTraversal(root);
  }

  private void printPostOrderTraversal(Node node)
  {
    if(node == null)
    {
      return;
    }

    printPostOrderTraversal(node.getRightNode());
    printPostOrderTraversal(node.getLeftNode());
    System.out.println(node.getPayload());
  }
}
