package assignment_Trees;

import java.util.Scanner;

public class BT_LowestCommonAncestor {
	static Scanner scn = new Scanner(System.in);

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;

		public BinaryTree() {
			root = takeInput();
		}

		private Node takeInput() {
			Node nn = new Node();
			int item = scn.nextInt();
			nn.data = item;
			boolean hlc = scn.nextBoolean();
			if (hlc) {
				nn.left = takeInput();
			}
			boolean hrc = scn.nextBoolean();
			if (hrc) {
				nn.right = takeInput();
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

		public int LCA(int n, int m) {
			return LCA(root, n, m).data;
		}

		private Node LCA(Node node, int n, int m) {
			if(node==null) {
				return null;
			}
			if(node.data==n||node.data==m) {
				return node;
			}
			Node leftLca=LCA(node.left, n, m);
			Node rightLca=LCA(node.right, n, m);
			if(leftLca!=null&&rightLca!=null) {
				return node;
			}else {
				return (leftLca!=null)?leftLca:rightLca;
			}
		}
		private class LCAPair{
			boolean isMatching;
			int lca;
		}
//		private LCAPair LCA2(Node node,int n,int m) {
//			
//		}
	}

	public static void main(String[] args) {
		BT_LowestCommonAncestor obj = new BT_LowestCommonAncestor();
		BinaryTree bt = obj.new BinaryTree();
		int n = scn.nextInt();
		int m = scn.nextInt();
		bt.display();
		System.out.println(bt.LCA(n, m));
	}

}
