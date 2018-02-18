import java.util.Queue;
import java.util.LinkedList;

class Node{
	int data;
	Node left,right;
	
	public Node(int item){
		data = item;
		left = right = null;
	}
}
public class BinaryTree {
	Node root;
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        
        System.out.println("In-order traversal: ");
        tree.printTree(tree.root);			//in-order traversal
        System.out.println("\nLevel-order traversal: ");
        tree.printLevelOrder(tree.root);
	}
	
	public void printTree(Node root){
		if(root == null)
			return;
		
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}
	
	public void printLevelOrder(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
}
