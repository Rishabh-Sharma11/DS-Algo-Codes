package lec32_SegmentTree;

public class SegmentTree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;

	public SegmentTree(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;
		if (lo == hi) {
			nn.data = arr[lo];
			return nn;
		}
		int mid = (lo + hi) / 2;
		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);
		nn.data = nn.left.data + nn.right.data;
		return nn;
	}

	public void display() {
		System.out.println("----------------------------");
		display(root);
		System.out.println("----------------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " -> " + node.data + " <- ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int query(int qsi, int qei) {
		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {

		// full contribution
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		}

		// no contribution
		else if (node.ei < qsi || node.si > qei) {
			return 0;
		}

		// partial contribution
		else {
			int l = query(node.left, qsi, qei);
			int r = query(node.right, qsi, qei);
			return l + r;
		}
	}

	public void update(int idx, int item) {
		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {
		if (node.si == idx && node.ei == idx) {
			node.data = item;
		} else if (node.si <= idx && node.ei >= idx) {		//equal sign bcz there may be the case of (0,idx) (for example)
			update(node.left, idx, item);
			update(node.right, idx, item);
			node.data = node.left.data + node.right.data;
		}

	}

}
