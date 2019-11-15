package assignment_Trees;

import java.util.Scanner;

public class BT_Sibling {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_Sibling m = new BT_Sibling();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();
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

		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
			// write your code here
			if (node == null) {
				return;
			}
			if (node.left == null&&node.right!=null) {
				System.out.print(node.right.data + " ");
			} else if (node.right == null&&node.left!=null) {
				System.out.print(node.left.data + " ");
			}

			sibling(node.left);
			sibling(node.right);
		}

	}

}
