package lec21_oct16_linkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int getFirst() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is empty.");
		}
		return head.data;
	}

	public int getLast() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is empty.");
		}
		return tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty.");
		}
		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid index.");
		}
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty.");
		}
		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid index.");
		}
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void display() {
		Node temp = head;
		System.out.println("------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("------------------------");
	}

	public void addLast(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null; // not required as it is by default null

		// attach node to the existing list
		if (size > 0) {
			tail.next = nn;
		}

		// data members
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}

	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null; // not required as it is by default null

		// attach node to the existing list
		nn.next = head;

		// data members
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}
	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// data members
			size++;
		}
	}

	public int removeFirst() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is empty.");
		}
		if (size == 1) {
			int temp = head.data;
			head = null;
			tail = null;
			size = 0;
			return temp;
		} else {
			int temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
	}

	public int removeLast() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is empty.");
		}
		if (size == 1) {
			int temp = tail.data;
			head = null;
			tail = null;
			size = 0;
			return temp;
		} else {
			int temp = tail.data;
			Node nm1 = getNodeAt(size - 2);
			nm1.next = null;
			tail = nm1;
			size--;
			return temp;
		}
	}

	public int removeAt(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty.");
		}
		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid index.");
		}
		if (size == 1) {
			int temp = tail.data;
			head = null;
			tail = null;
			size = 0;
			return temp;
		} else {
			if (idx == 0) {
				return removeFirst();
			} else if (idx == size - 1) {
				return removeLast();
			} else {
				Node nm1 = getNodeAt(idx - 1);
				Node n = nm1.next;
				Node np1 = n.next; // or nm1.next.next

				int temp = n.data;
				nm1.next = np1;
				size--;
				return temp;
			}
		}
	}

	public void RDI() throws Exception { // Reverse data iteratively

//		Node temp2 = head;
//		for (int i = 0; i < size() / 2; i++) {
//			Node temp = head;
//			for (int j = 0; j < size() - i - 1; j++) {
//				temp = temp.next;
//			}
//			int datatemp = temp2.data;
//			temp2.data = temp.data;
//			temp.data = datatemp;
//			temp2 = temp2.next;
//		}

		int left = 0;
		int right = size - 1;

		while (left < right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}

	}

	public void RPI() { // Reverse pointer iteratively
		Node prev = head;
		Node curr = head.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;

		temp.next = null;

	}

	public void RPR() { // Reverse pointer recursively
		RPR(null, head);

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;

		// we didn't put temp.next=null; bcz we passed null and head so this is executed
		// at the beginning
	}

	private void RPR(Node prev, Node curr) { // using 2 pointers
		if (curr == null) {
			return;
		}

		RPR(curr, curr.next);
		curr.next = prev;
	}

	private void RPR(Node temp) { // Using 1 pointer
		if (temp.next == null) {
			return;
		}
		temp.next.next = temp;
	}

	public void RDR() {
//		RDRreturn(head,head,0);

		HeapMover mover = new HeapMover();
		mover.left = head;
		RDRHeap(mover, head, 0);
	}

	private Node RDRreturn(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		Node cl = RDRreturn(left, right.next, count + 1); // cl=correct left
		if (count >= size / 2) { // swap
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}
		return cl.next;
	}

	private class HeapMover {
		Node left;
	}

	private void RDRHeap(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}
		RDRHeap(mover, right.next, count + 1);
		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	public void Fold() {
		Fold(head, head, 0);
	}

	private Node Fold(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		Node cl = Fold(left, right.next, count + 1);
		if (count > size / 2) {
			Node ahead = cl.next;
			cl.next = right;
			right.next = ahead;

			return ahead;
		}
		if (count == size / 2) {
			tail = right;
			tail.next = null;
		}

		return null;
	}

	public int Mid() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow.data;
	}

	public int kFromLast(int k) {
		Node back = head;
		Node forward = head;

		for (int i = 0; i < k; i++) {
			forward = forward.next;
		}

		while (forward != null) {
			back = back.next;
			forward = forward.next;
		}
		return back.data;
	}

	public int createDummyListForIntersection() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		n9.next = n10;
		n10.next = n6;
		Node h1 = n1;
		Node h2 = n9;

//		return intersectionUsingThereSizes(h1, h2);
		return intersectionWithoutUsingSizes(h1, h2);
	}

	private int intersectionUsingThereSizes(Node h1, Node h2) {
		int m = size(h1);
		int n = size(h2);
		Node ptr1 = h1;
		Node ptr2 = h2;
		if (m > n) {
			for (int i = 1; i <= m - n; i++) {
				ptr1 = ptr1.next;
			}
		} else if (n > m) {
			for (int i = 1; i <= n - m; i++) {
				ptr2 = ptr2.next;
			}
		}
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1.data;

	}

	public int size(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public int intersectionWithoutUsingSizes(Node h1, Node h2) {
		Node fp = h1;
		Node sp = h2;
		while (fp != sp) {
			if (fp == null) {
				fp = h2;
			} else {
				fp = fp.next;
			}

			if (sp == null) {
				sp = h1;
			} else {
				sp = sp.next;
			}
		}
		return fp.data;
	}

	public void kReverse(int k) throws Exception {
		LinkedList prev = null;
		while (size != 0) {
			LinkedList curr = new LinkedList();
			for (int i = 1; i <= k && size != 0; i++) {
				curr.addFirst(this.removeFirst());
			}
			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}
//	public boolean DetectLoop() {	//use only head
//		Node slow=head;
//		Node fast=head;
//		
//		
//	}

}
