
public class BstSingleChildCheck {
	Node root;
	int[] temp = new int[7];
	int count = 0;
	public static void main(String[] args){
		BstSingleChildCheck check = new BstSingleChildCheck();
		BinarySearchTree tree = new BinarySearchTree();
		//BST insertion
		check.insert(50);
		check.insert(30);
		check.insert(20);
		check.insert(10);
		//check.insert(70);
		//check.insert(60);
		//check.insert(80);
        check.preOrder(check.root);
        if (check.hasOnlyOneChild(check.temp, check.count) == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
	}

	boolean hasOnlyOneChild(int pre[], int size) {
	    // Initialize min and max using last two elements
	    int min, max;
	    if (pre[size - 1] > pre[size - 2]) {
	        max = pre[size - 1];
	        min = pre[size - 2];
	    } else {
	        max = pre[size - 2];
	        min = pre[size - 1];
	    }
	
	    // Every element must be either smaller than min or
	    // greater than max
	    for (int i = size - 3; i >= 0; i--) {
	        if (pre[i] < min) {
	            min = pre[i];
	        } else if (pre[i] > max) {
	            max = pre[i];
	        } else {
	            return false;
	        }
	    }
	    return true;
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
	
	public void preOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		temp[count++] = root.data;
		preOrder(root.left);
		preOrder(root.right);
	}
}