import java.util.Scanner;

class RemoveDList{
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

	//remove duplicates
	public static void removeDuplicates(RemoveDList li){
		if(li.head==null){
			System.out.println("Linked-list doesn't exists.OOPS!!");
			return;
		}
		Node temp=li.head;
		while(temp!=null){
			Node temp1=temp;

			while(temp1!=null && temp1.data==temp.data){
				temp1=temp1.next;
			}
			temp.next=temp1;
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		RemoveDList li=new RemoveDList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the linked-list: ");
		int n=sc.nextInt();
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			int data=sc.nextInt();
			li.insert(data);
		}
		display();
		System.out.println();
		removeDuplicates(li);
		System.out.println();
		display();
		sc.close();
	}
}