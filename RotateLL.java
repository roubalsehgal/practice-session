import java.util.Scanner;

public class RotateLL {
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

	public void rotateIt(int k) {
		if (this.head == null || this.head.next == null)
			return;
		int len = getLength(this.head);
		k = k % len;
		if (k > 0) {
			Node curr = this.head;
			Node pre = null;
			while (--k >= 0) {
				pre = this.head;
				this.head = this.head.next;
			}
			pre.next = null;
			Node newHead = this.head;
			while (this.head.next != null) {
				this.head = this.head.next;
			}
			this.head.next = curr;
			this.head = newHead;
		}
	}

	private int getLength(Node head) {
		if (head == null)
			return 0;
		return 1 + getLength(head.next);
	}

	public static void main(String[] args) {
		RotateLL li = new RotateLL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the linked-list: ");
		int size = sc.nextInt();
		System.out.println("Enter the elements: ");
		for (int i = 0; i < size; i++) {
			li.addLast(sc.nextInt());
		}
		System.out.println("Enter the value of k: ");
		int k = sc.nextInt();
		li.rotateIt(k);
		li.display();
		sc.close();
	}
}
