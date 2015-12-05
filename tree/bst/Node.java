public class Node
{
  private int payload;
  private Node leftNode;
  private Node rightNode;

  public Node(final int payload)
  {
    this(payload, null, null);
  }
  
  public Node(final int payload, final Node leftNode, final Node rightNode)
  {
    this.payload = payload;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public int getPayload()
  {
    return payload;
  }

  public Node getLeftNode()
  {
    return leftNode;
  }

  public void setLeftNode(final Node leftNode)
  {
    this.leftNode = leftNode;
  }

  public Node getRightNode()
  {
    return rightNode;
  }

  public void setRightNode(final Node rightNode)
  {
    this.rightNode = rightNode;
  }
}
