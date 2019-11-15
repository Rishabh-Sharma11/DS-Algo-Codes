package assignment_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BT_RightView {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_RightView m = new BT_RightView();
		BinaryTree bt = m.new BinaryTree();
		bt.rightView();
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
			root = takeInput();

		}

		private Node takeInput() {
			Node ro = new Node();
			ro.data = scn.nextInt();
			Queue<Node> queue = new LinkedList<>();
			queue.add(ro);
			while (!queue.isEmpty()) {
				Node rv = queue.remove();
				int l = scn.nextInt();
				int r = scn.nextInt();
				if (l != -1) {
					Node nl = new Node();
					nl.data = l;
					rv.left = nl;
					queue.add(nl);
				}
				if (r != -1) {
					Node nr = new Node();
					nr.data = r;
					rv.right = nr;
					queue.add(nr);
				}
			}
			return ro;
		}

		public void rightView() {
			rightView(root, 1);
		}
		int maxLevel=0;
		private void rightView(Node node, int level) {
			if(node==null) {
				return;
			}
			
			if(level>maxLevel) {
				System.out.print(node.data+" ");
				maxLevel=level;
			}
			rightView(node.right, level+1);
			rightView(node.left, level+1);
			
		}
		
	}

}
