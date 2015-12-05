public class BinarySearchTree
{
  private Node root;

  public void insertNode(final Node node)
  {
    if(root == null)
    {
      root = node;
      return;
    }

    Node parentNode = findParentNodeFor(root, node);

    if(node.getPayload() == parentNode.getPayload())
    {
      return;
    }
    if(node.getPayload() > parentNode.getPayload())
    {
      parentNode.setLeftNode(node);
    }
    else
    {
      parentNode.setRightNode(node);
    }
  }

  private Node findParentNodeFor(final Node currentNode, final Node node)
  {
    if(currentNode.getPayload() == node.getPayload())
    {
      return currentNode;
    }

    if(node.getPayload() > currentNode.getPayload()) 
    {
      if(currentNode.getLeftNode() == null)
      {
        return currentNode;
      }
      else
      {
        return findParentNodeFor(currentNode.getLeftNode(), node);
      }
    }
    else
    {
      if(currentNode.getRightNode() == null)
      {
        return currentNode;
      }
      else
      {
        return findParentNodeFor(currentNode.getRightNode(), node);
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
}
