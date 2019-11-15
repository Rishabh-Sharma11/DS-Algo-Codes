package assignment_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BT_TopView {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_TopView m = new BT_TopView();
		BinaryTree bt = m.new BinaryTree();
		bt.topView();
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
		
		public void topView() {
			topView(root,true,true);
		}

		private void topView(Node node,boolean leftCall,boolean rightCall) {
			if(node==null) {
				return;
			}
			
			if(leftCall) {
				topView(node.left,true,false);
			}
			
			System.out.print(node.data+" ");
			
			if(rightCall) {
				topView(node.right,false,true);
			}
			
		}
	}

}
