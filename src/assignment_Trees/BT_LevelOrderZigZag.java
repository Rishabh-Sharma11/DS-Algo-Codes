package assignment_Trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BT_LevelOrderZigZag {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_LevelOrderZigZag m = new BT_LevelOrderZigZag();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

		public void levelOrderZZ() {
			
			// write your code here
			int count = 0;

			LinkedList<Node> queue = new LinkedList<>();
			LinkedList<Node> stack = new LinkedList<>();

			queue.addLast(root);

			while (!queue.isEmpty()) {

				Node rn = queue.removeFirst();

				System.out.print(rn.data + " ");

				if (count % 2 == 0) {
					if(rn.left!=null) {
						stack.addFirst(rn.left);
					}
					if(rn.right!=null) {
						stack.addFirst(rn.right);
					}
				} else {
					if(rn.right!=null) {
						stack.addFirst(rn.right);
					}
					if(rn.left!=null) {
						stack.addFirst(rn.left);
					}
				}

				if (queue.isEmpty()) {
					queue = stack;
					stack = new LinkedList<>();

					System.out.println();

					count++;
				}

			}
		}

	}


}
