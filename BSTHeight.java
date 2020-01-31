import java.util.Scanner;

class BSTHeight{
	private class Node{
		int key;
		Node left;
		Node right;
		Node(int data){
			this.key=data;
		}
	}
	private Node root;

	public void insert(int item){
		this.root=insert(root, item);
	}

	private Node insert(Node root, int item){
		if(root==null){
			Node nn=new Node(item);
			root=nn;
			return root;
		}
		else if(item<root.key){
			root.left=insert(root.left, item);
		}
		else if(item>root.key){
			root.right=insert(root.right, item);
		}
		return root;
	}

	public void inOrder(){
		inOrder(this.root);
	}

	private void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.key+"-->");
		inOrder(root.right);
	}

	public int height(){
		return height(this.root);
	}

	private int height(Node root){
		if(root==null){
			return -1;
		}

		int lheight=height(root.left);
		int rheight=height(root.right);

		int ans=Math.max(lheight, rheight)+1;

		return ans;

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BSTHeight tree=new BSTHeight();

		//insertion
		tree.insert(5);
		tree.insert(3);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		tree.insert(6);
		tree.insert(8);

		//display
		System.out.println("Inorder Printing");
		tree.inOrder();

		//height
		System.out.print("\nHeight of the tree: "+tree.height());
	}
}