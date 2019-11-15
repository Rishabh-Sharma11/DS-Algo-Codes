package assignment_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BT_ArraylistOfLevel {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_ArraylistOfLevel m = new BT_ArraylistOfLevel();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
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

		public ArrayList<ArrayList<Integer>> levelArrayList() {

			// write your code here
			LinkedList<Node> primary=new LinkedList<>();
			LinkedList<Node> helper=new LinkedList<>();
			ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> al=new ArrayList<>();
			primary.addLast(root);
			while(!primary.isEmpty()) {
				Node rn=primary.removeFirst();
				
				al.add(rn.data);
				if(rn.left!=null) {
					helper.addLast(rn.left);
				}
				if(rn.right!=null) {
					helper.addLast(rn.right);
				}
				
				if(primary.isEmpty()) {
					primary=helper;
					helper=new LinkedList<>();
					all.add(al);
					al=new ArrayList<>();
					
				}
			}
			return all;
			
		}

	}

}
