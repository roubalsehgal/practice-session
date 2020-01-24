import java.util.Scanner;

class ReverseLL{
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	static Node head;

	//Insert at the end of the linked-list
	public static void insert(int item){
		if(head==null){
			Node nn=new Node(item);
			head=nn;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		Node nn=new Node(item);
		temp.next=nn;
	}
	
	//display the linked-list
	public static void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.print("NULL");
	}

	//reverse the linked-list
	public static void reverse(){
		if(head==null){
			System.out.println("Linked-list doesn't exists.OOPS!!");
			return;
		}
		Node prev=null;
		Node curr=head;
		Node next=null;

		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}

	public static void main(String[] args) {
		ReverseLL LL=new ReverseLL();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the linked-list: ");
		int n=sc.nextInt();
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			int data=sc.nextInt();
			LL.insert(data);
		}
		display();
		System.out.println();
		reverse();
		System.out.println();
		display();
		sc.close();
	}
}