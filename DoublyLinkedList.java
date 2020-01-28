import java.util.Scanner;

class DoublyLinkedList {
	private class Node {
		int data;
		Node next;
		Node prev;
	}

	private Node head;
	private Node tail;
	private int size;
	
	public void addLast(int item) {
		// create a new Node
		Node nn = new Node();
		nn.data = item;
		nn.prev=null;
		nn.next = null;

		// attach Node
		if (this.size >= 1) {
			this.tail.next = nn;
			nn.prev=this.tail;
		}

		// summary object
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}
	
	public void pairs( int k) {
		pairs(this.tail,k);
	}
	private void pairs(Node temp,int k) {
		if(temp==null){
			return;
		}
	    int x=find(temp,temp.prev, k);
	    if(x!=0){
	    	System.out.print("{"+temp.data+", "+x+"}, ");
	    }
	    pairs(temp.prev,k);
	}
	private int find(Node temp,Node back,int k)
	{
		if(back==null)
		{
			return 0;
		}
		if(temp.data+back.data==k)
		{
			return back.data;
		}
		return find(temp,back.prev,k);
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		DoublyLinkedList li=new DoublyLinkedList();
		System.out.println("Enter the size of the Linked-List: ");
		int size=sc.nextInt();
		for(int i=0;i<size;i++){
			int data=sc.nextInt();
			li.addLast(data);
		}
		System.out.println("Enter the value of k: ");
		int k=sc.nextInt();
		li.pairs(k);
		sc.close();
	}
}