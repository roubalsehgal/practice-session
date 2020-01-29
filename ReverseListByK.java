import java.util.Scanner;

class ReverseListByK {
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
		nn.prev = null;
		nn.next = null;

		// attach Node
		if (this.size >= 1) {
			this.tail.next = nn;
			nn.prev = this.tail;
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

	public void reverseIt(int k) {
		this.head = reverseIt(this.head, k);
	}

	private Node reverseIt(Node temp, int k) {
		Node next = null;
		Node curr = temp;
		Node prev = null;

		int count = 0;
		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null)
			head.next = reverseIt(next, k);
		return prev;
	}

	public void display() {
		Node temp = this.head;
		System.out.println("---------------------");
		while (temp != null) {
			System.out.print(temp.data + "-> ");
			temp = temp.next;
		}
		System.out.println("---------------------");
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ReverseListByK li = new ReverseListByK();
		System.out.println("Enter the size of the Linked-List: ");
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			int data = sc.nextInt();
			li.addLast(data);
		}
		System.out.println("Enter the value of k: ");
		int k = sc.nextInt();
		li.reverseIt(k);
		li.display();
		sc.close();
	}
}