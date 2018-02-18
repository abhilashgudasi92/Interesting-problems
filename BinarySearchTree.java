
public class BinarySearchTree {
	Node root;
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		BinarySearchTree tree = new BinarySearchTree();
		//BST insertion
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        bt.printTree(tree.root);
        //BST deletion
        tree.delete(80);
        System.out.println("\nAfter delete:");
        bt.printTree(tree.root);
        
        //Checking if tree is BST
        if (tree.isBST())
            System.out.println("\nIs BST");
        else
            System.out.println("\nNot a BST");
        
        //Printing the values of BST in range k1,k2
        int k1 = 10;
        int k2 = 25;
        System.out.println("In range between " + k1 +" and " + k2);
        tree.printInRange(tree.root, k1, k2);
        
        //Change / decrease key value
        int oldKey = 40;
        int newKey = 10;
        tree.changeKey(oldKey,newKey);
        System.out.println("\nAfter changing key from "+oldKey+" to "+newKey);
        bt.printTree(tree.root);
	}
	
	void insert(int key){
		root = insertRec(root,key);
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
	
	void delete(int key){
		root = deleteRec(root,key);
	}
	
	Node deleteRec(Node root,int key){
		if(root == null)
			return root;
		if(root.data > key){
			root.left = deleteRec(root.left,key);
		}
		else if(root.data < key)
			root.right = deleteRec(root.right,key);
		
		else{
			// node with only one child or no child
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			//node with two children: Get the in-order successor (smallest
            // in the right subtree)
			root.data = minValue(root.right);
			
			root.right = deleteRec(root.right,root.data);
		}
		return root;
	}
	
	int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
	
	void changeKey(int oldKey, int newKey){
		delete(oldKey);
		insert(newKey);
	}
	
	/* returns true if given search tree is binary
    search tree (efficient version) */
   boolean isBST()  {
       return isBSTUtil(root, Integer.MIN_VALUE,
                              Integer.MAX_VALUE);
   }

   /* Returns true if the given tree is a BST and its
     values are >= min and <= max. */
   boolean isBSTUtil(Node node, int min, int max)
   {
       /* an empty tree is BST */
       if (node == null)
           return true;

       /* false if this node violates the min/max constraints */
       if (node.data < min || node.data > max)
           return false;

       /* otherwise check the subtrees recursively
       tightening the min/max constraints */
       // Allow only distinct values
       return (isBSTUtil(node.left, min, node.data-1) &&
               isBSTUtil(node.right, node.data+1, max));
   }
   
   /* The functions prints all the keys which in the given range [k1..k2].
   The function assumes than k1 < k2 */
  void printInRange(Node node, int k1, int k2) {
       
      /* base case */
      if (node == null) {
          return;
      }

      /* Since the desired o/p is sorted, recurse for left subtree first
       If root->data is greater than k1, then only we can get o/p keys
       in left subtree */
      if (k1 < node.data) {
    	  printInRange(node.left, k1, k2);
      }

      /* if root's data lies in range, then prints root's data */
      if (k1 <= node.data && k2 >= node.data) {
          System.out.print(node.data + " ");
      }

      /* If root->data is smaller than k2, then only we can get o/p keys
       in right subtree */
      if (k2 > node.data) {
    	  printInRange(node.right, k1, k2);
      }
  }
		
}
