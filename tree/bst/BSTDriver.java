import java.util.Random;

public class BSTDriver
{
  public static void main(String args[])
  {
    final BinarySearchTree bst = new BinarySearchTree();

    for(int i = 0; i < 10; i++)
    {
      int payload = new Random().nextInt(100 + i);
      System.out.println("Inserting " + payload);
      final Node node = new Node(payload);
      bst.insertNode(node);
    }
    bst.inOrderTraversal();
  }
} 
