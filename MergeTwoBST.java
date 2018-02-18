import java.util.Stack;

public class MergeTwoBST {
	Node root,root2;
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		MergeTwoBST twoBT = new MergeTwoBST();
		
		//BST1 insertion
		twoBT.insert(20);
		twoBT.insert(40);
		twoBT.insert(60);
		twoBT.insert(80);
		twoBT.insert(100);
		twoBT.insert(120);
		twoBT.insert(140);
        
        bt.printTree(twoBT.root);
        System.out.println();
        //BST2 insertion
        twoBT.insert2(10);
		twoBT.insert2(30);
		twoBT.insert2(50);
		twoBT.insert2(70);
		twoBT.insert2(90);
		twoBT.insert2(110);
		twoBT.insert2(130);
        
        bt.printTree(twoBT.root2);
        System.out.println();
        // Print sorted nodes of both trees
        twoBT.merge(twoBT.root, twoBT.root2);
     
	}
	
	Stack<Node> s1 = new Stack<Node>();
	Stack<Node> s2 = new Stack<Node>();
	
	void merge(Node root, Node root2){
		Node current = root;
		Node current2 = root2;
		BinaryTree bt = new BinaryTree();
		if(root == null){
			bt.printTree(root2);
			return;
		}
		if(root2 == null){
			bt.printTree(root);
			return;
		}
		while(current != null || !s1.isEmpty() || current2!= null|| !s2.isEmpty()){
			if(current !=null || current2 != null){
				if(current!=null){
					s1.push(current);
					current = current.left;
				}
				if(current2!=null){
					s2.push(current2);
					current2 = current2.left;
				}
			}
			else{
				if (s1.isEmpty())
	            {
	                while (!s2.isEmpty())
	                {
	                	current2 = s2.pop();
	                	current2.left = null;
	                    bt.printTree(current2);
	                }
	                return ;
	            }
				if (s2.isEmpty())
	            {
	                while (!s1.isEmpty())
	                {
	                	current = s1.pop();
	                	current.left = null;
	                    bt.printTree(current);
	                }
	                return ;
	            }
				current = s1.pop();
				current2 = s2.pop();
				
				if(current.data < current2.data){
					System.out.print(current.data +" ");
					current = current.right;
					s2.push(current2);
					current2 = null;
				}
				else{
					System.out.print(current2.data+" ");
					current2 = current2.right;
					s1.push(current);
					current = null;
				}
			}
		}
		
	}
	void insert(int key){
		root = insertRec(root,key);
	}
	void insert2(int key){
		root2 = insertRec(root2,key);
	}
	
	Node insertRec(Node root,int key){
		if(root == null){
			root = new Node(key);
			return root;
		}
		
		if(root.data > key){
			root.left = insertRec(root.left,key);
		}
		else
			root.right = insertRec(root.right,key);
		return root;
	}
}
