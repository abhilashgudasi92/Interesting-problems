/* BST should maintain BT structure*/
public class BTtoBST {
	Node root;
	int[] temp = new int[5];
	int count = 0;
	public static void main(String[] args){
		BTtoBST bst = new BTtoBST();
		mergeSort ms = new mergeSort();
		selectionSortArray s = new selectionSortArray();
		bst.root = new Node(10);
		bst.root.left = new Node(2);
		bst.root.right = new Node(7);
		bst.root.left.left = new Node(8);
		bst.root.left.right = new Node(4);
        
        System.out.println("In-order traversal:BT ");
        bst.inOrderBt(bst.root);			//in-order traversal
        ms.MS(bst.temp, 0, bst.temp.length-1);
        System.out.println("\nSorted list: ");
        s.printArray(bst.temp);
        System.out.println("\nIn-order traversal:BST ");
        bst.count = 0;
        bst.inOrderBst(bst.root);
	}
	public void inOrderBt(Node root){
		if(root == null)
			return;
		
		inOrderBt(root.left);
		System.out.print(root.data + " ");
		temp[count++] = root.data;
		inOrderBt(root.right);
	}
	
	public void inOrderBst(Node root){
		if(root == null)
			return;
		
		inOrderBst(root.left);
		root.data = temp[count++];
		System.out.print(root.data + " ");
		inOrderBst(root.right);
	}
	
	
}
