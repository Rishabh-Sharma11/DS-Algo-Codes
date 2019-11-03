package lec25_BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	Scanner scn;

	public BinaryTree(String str) {
		scn = new Scanner(str);
		root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter the data for root node? ");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data + "?");
			} else {
				System.out.println("Enter the data for right child of " + parent.data + "?");
			}
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left node?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println(nn.data + " has right node?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = takeInput(nn, false);
		}

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {
//		int ts = 0;
//		if (node.left != null) {
//			ts += size(node.left);
//		}
//		if (node.right != null) {
//			ts += size(node.right);
//		}
//		return ts + 1;

		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int max = node.data;
		int lmax = max(node.left);
		int rmax = max(node.right);
		max = Math.max(lmax, rmax);
		max = Math.max(max, node.data);

		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		boolean lr = find(node.left, item);
		if (lr)
			return true;
		boolean rr = find(node.right, item);
		return lr || rr;
	}

	public int diameter1() {
		diameter1(root);
		return maxDiameter;
	}

	private int maxDiameter = 0;

	private void diameter1(Node node) { // O(n2)
		if (node == null) {
			return;
		}
		int self = height(node.left) + height(node.right) + 2;
		if (self > maxDiameter) {
			maxDiameter = self;
		}

		diameter1(node.left);
		diameter1(node.right);
	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) { // O(n2)
		if (node == null) {
			return 0;
		}
		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sd = height(node.left) + height(node.right) + 2;
		return Math.max(sd, Math.max(ld, rd));
	}

	private class DiaPair {
		int diameter = 0; // default-- scope=package
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).diameter;
	}

	private DiaPair diameter3(Node node) {
		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();
		int sd = ldp.ht + rdp.ht + 2;
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		sdp.diameter = Math.max(sd, Math.max(ldp.diameter, rdp.diameter));
		return sdp;

	}

	public boolean isBalanced2() { // recursion return
		return isBalanced2(root);
	}

	private boolean isBalanced2(Node node) {
		if (node == null) {
			return true;
		}

		int sbf = height(node.left) - height(node.right);
		if (sbf != -1 && sbf != 0 && sbf != 1) {
			return false;
		}

		boolean lr = isBalanced2(node.left);
		boolean rr = isBalanced2(node.right);

		if (lr && rr) {
			return true;
		}

		return false;
	}

	private class BalancePair {
		int ht = -1;
		boolean isBal = true;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).isBal;
	}

	private BalancePair isBalanced3(Node node) {
		if (node == null) {
			return new BalancePair();
		}

		BalancePair lbp = isBalanced3(node.left);
		BalancePair rbp = isBalanced3(node.right);

		BalancePair sbp = new BalancePair();

		int bf = lbp.ht - rbp.ht;
		if (lbp.isBal && rbp.isBal && (bf == -1 || bf == 0 || bf == 1)) {
			sbp.isBal = true;
		} else {
			sbp.isBal = false;
		}

		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
		return sbp;
	}

	public boolean FlipEquivalent(BinaryTree other) {
		return FlipEquivalent(root, other.root);
	}

	private boolean FlipEquivalent(Node t, Node o) {
//		if(t.left.data==o.left.data&&t.right.data==o.left.data) {
//			FlipEquivalent(t.left, o.left);
//		}else if(t.left.data==o.right.data&&t.right.data==o.left.data) {
//			
//		}else {
//			return false;
//		}
//		
		if (t == null && o == null) {
			return true;
		}
		if (t == null || o == null) {
			return false;
		}

		if (t.data != o.data) {
			return false;
		}
		// when we don't need flips
		boolean ll = FlipEquivalent(t.left, o.left);
		boolean rr = FlipEquivalent(t.right, o.right);

		// when we need flip
		boolean lr = FlipEquivalent(t.left, o.right);
		boolean rl = FlipEquivalent(t.right, o.left);

		return (ll && rr) || (lr && rl);

	}

	public void PreOrder() {
		PreOrder(root);
		System.out.println();
	}

	private void PreOrder(Node node) {
		if (node == null) {
			return;
		}
		// N
		System.out.print(node.data + " ");

		// L
		PreOrder(node.left);

		// R
		PreOrder(node.right);

	}

	private class PreOrderPair {
		Node n;
		boolean sd; // self done
		boolean ld; // left done
		boolean rd; // right done
	}

	public void PreOrderIteratively() {
		Stack<PreOrderPair> stack = new Stack<>();
		PreOrderPair sp = new PreOrderPair(); // starting pair
		sp.n = root;
		stack.add(sp);
		while (!stack.isEmpty()) {
			PreOrderPair tp = stack.peek(); // top pair
			if (tp.n == null) {
				stack.pop();
				continue;
			}
			if (tp.sd == false) {
				System.out.print(tp.n.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {
				PreOrderPair np = new PreOrderPair(); // new pair
				np.n = tp.n.left;
				stack.push(np);
				tp.ld = true;
			} else if (tp.rd == false) {
				PreOrderPair np = new PreOrderPair();
				np.n = tp.n.right;
				stack.push(np);
				tp.rd = true;
			} else {
				stack.pop();
			}

		}
		System.out.println();
	}

//	public int MaxSubTreeSum1() {
//		int[]arr=new int[1];
//		arr[0]=Integer.MIN_VALUE;
//		MaxSub
//	}

	private class MaxSubTreePair {
		int entireSum = 0;
		int maxSTsum = Integer.MIN_VALUE;
	}

	public int MaxSubTreeSum3() {
		return MaxSubTreeSum3(root).maxSTsum;
	}

	private MaxSubTreePair MaxSubTreeSum3(Node node) {
		if (node == null) {
			return new MaxSubTreePair();
		}

		MaxSubTreePair lp = MaxSubTreeSum3(node.left);
		MaxSubTreePair rp = MaxSubTreeSum3(node.right);

		MaxSubTreePair sp = new MaxSubTreePair();
		sp.entireSum = lp.entireSum + rp.entireSum + node.data;

		sp.maxSTsum = Math.max(sp.entireSum, Math.max(lp.maxSTsum, rp.maxSTsum));
		return sp;
	}

//	public int MaxPathSum() {
//		
//	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];
		int si = -1;
		int nel = 0;
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;

	}

	private class BSTPair {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isBST = true;
	}

	public boolean checkBST() {
		return checkBST(root).isBST;
	}

	private BSTPair checkBST(Node node) { // my solution
		if (node == null) {
			BSTPair obj = new BSTPair();
			return obj;
		}

		BSTPair lobj = checkBST(node.left);
		BSTPair robj = checkBST(node.right);

		BSTPair bobj = new BSTPair();

		if (!(lobj.max < node.data && robj.min > node.data && lobj.isBST && robj.isBST)) {
			bobj.isBST = false;
			return bobj;
		}

		bobj.max = Math.max(node.data, Math.max(lobj.max, robj.max));
		bobj.min = Math.min(node.data, Math.min(lobj.min, robj.min));

		return bobj;
	}

	public boolean largestBSTi() {
		return largestBST2(root).isBST;
	}

	private BSTPair largestBST2(Node node) { // incomplete
		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.isBST = true;
			return bp;
		}

		BSTPair lbp = largestBST2(node.left);
		BSTPair rbp = largestBST2(node.right);
		BSTPair sbp = new BSTPair();

		boolean sb = false;
		if (node.data > lbp.min && node.data < rbp.max) {
			sb = true;
		}

		sbp.max = Math.max(node.data, Math.max(lbp.max, rbp.max));
		sbp.min = Math.min(node.data, Math.min(lbp.min, rbp.min));

		sbp.isBST = lbp.isBST && rbp.isBST && sb;
		return sbp;
	}

	public int largestBST() {
		return largestBST3(root).largestBSTNode.data;
	}

	private class BSTPairs {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isBST = true;
		Node largestBSTNode;
		int size;
	}

	private BSTPairs largestBST3(Node node) {
		if (node == null) {
			BSTPairs bp = new BSTPairs();
			return bp;
		}

		BSTPairs lbp = largestBST3(node.left);
		BSTPairs rbp = largestBST3(node.right);
		BSTPairs sbp = new BSTPairs();

		if (node.data > lbp.max && node.data < rbp.min && lbp.isBST && rbp.isBST) {
			sbp.isBST = true;
			sbp.largestBSTNode = node;
			sbp.size = lbp.size + rbp.size + 1;
		} else {
			sbp.isBST = false;

			if (lbp.size > rbp.size) {
				sbp.largestBSTNode = lbp.largestBSTNode;
				sbp.size = lbp.size;
			} else {
				sbp.largestBSTNode = rbp.largestBSTNode;
				sbp.size = rbp.size;
			}

		}

		return sbp;
	}

}
