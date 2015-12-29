import java.util.Random;

public class BSTDriver
{
  public static void main(String args[])
  {
    final BinarySearchTree bst = new BinarySearchTree();
 
    final Random rand = new Random();
    for(int i = 0; i < 10; i++)
    {
      int payload = rand.nextInt(100);
      final Node node = new Node(payload);
      bst.insertNode(node);
    }
    bst.inOrderTraversal();
  }
} 
