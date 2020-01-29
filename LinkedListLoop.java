import java.util.HashSet;
import java.util.Scanner;

class LinkedListLoop {
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

	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index!");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void makeItCircular(int pos) throws Exception{
		Node nn = getNodeAt(pos - 1);
		this.tail.next = nn;
	}

	public boolean detectLoop() {
		HashSet<Node> hs = new HashSet<Node>();
		Node temp = this.head;
		while (temp != null) {
			if (hs.contains(temp)) {
				return true;
			}
			hs.add(temp);
			temp = temp.next;
		}
		return false;
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

	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of test-cases: ");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			LinkedListLoop li = new LinkedListLoop();
			System.out.println("Enter the size of the Linked-List: ");
			int size = sc.nextInt();
			System.out.println("Enter the elements: ");
			for (int j = 0; j < size; j++) {
				int data = sc.nextInt();
				li.addLast(data);
			}
			System.out.println("Enter the value of x: ");
			int x = sc.nextInt();
			if (x <= 0 || x > size)
				System.out.println("False");
			else {
				li.makeItCircular(x);
				boolean res = li.detectLoop();
				if (res) {
					System.out.print("True");
				} else
					System.out.print("False");
			}
		}
		sc.close();
	}
}