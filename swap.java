import java.util.Scanner;

class swap {
	private class Node {
		private int data;
		private Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(n)
	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
	}

	// O(1)
	public void addLast(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (this.size >= 1) {
			this.tail.next = nn;
		}
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void swap_pair() {
		Node temp = this.head;
		while (temp != null && temp.next != null) {
			int t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;

			// iterate
			temp = temp.next.next;
		}
	}

	public static void main(String args[]) {
		swap li = new swap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the linked list: ");
		int n = sc.nextInt();
		System.out.println("Enter the elements of the linked list: ");
		for (int i = 0; i < n; i++) {
			li.addLast(sc.nextInt());
		}
		// before swapping
		li.display();
		System.out.println();
		li.swap_pair();

		// after swapping
		li.display();
		sc.close();
	}
}