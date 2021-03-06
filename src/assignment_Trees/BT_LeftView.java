package assignment_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BT_LeftView {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_LeftView m = new BT_LeftView();
		BinaryTree bt = m.new BinaryTree();
		bt.leftView();
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

		public void leftView() {
			leftView(root, 1);
		}
		int maxLevel=0;
		private void leftView(Node node, int level) {
			if(node==null) {
				return;
			}
			
			if(level>maxLevel) {
				System.out.print(node.data+" ");
				maxLevel=level;
			}
			leftView(node.left, level+1);
			leftView(node.right, level+1);
			
		}
		
//		private int leftView2(Node node, int level,int maxLevel) {		//	Wrong
//			if(node==null) {
//				return Math.max(level, maxLevel);
//			}
//			if(level>maxLevel) {
//				System.out.print(node.data+" ");
//				maxLevel=level;
//			}
//			
//			int lr=leftView(node.left, level+1, maxLevel);
//			int rl=leftView(node.right, level+1, Math.max(maxLevel, lr));
//			
//			return Math.max(lr, rl);
//		}
	}

}
