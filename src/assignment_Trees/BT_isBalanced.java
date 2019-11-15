package assignment_Trees;

import java.util.Scanner;

public class BT_isBalanced {
static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		BT_isBalanced m = new BT_isBalanced();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced2());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}
		public int ht() {
			return ht(root);
		}

		private int ht(Node node) {

			if (node == null) {
				return -1;
			}

			int lh = ht(node.left);
			int rh = ht(node.right);

			return Math.max(lh, rh) + 1;
		}
		public Node takeInput(Node parent, boolean ilc) {
			
			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}
		public boolean isBalanced2() {
			return isBalanced2(root);
		}

		private boolean isBalanced2(Node node) {

			if (node == null) {
				return true;
			}

			boolean ilb = isBalanced2(node.left);
			boolean irb = isBalanced2(node.right);

			int bf = ht(node.left) - ht(node.right);

			if (ilb && irb && (bf == -1 || bf == 0 || bf == 1)) {
				return true;
			} else {
				return false;
			}

		}

	}

}
