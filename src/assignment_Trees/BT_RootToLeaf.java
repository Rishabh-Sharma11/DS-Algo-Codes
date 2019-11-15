package assignment_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class BT_RootToLeaf {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		BT_RootToLeaf m = new BT_RootToLeaf();
		BinaryTree bt = m.new BinaryTree();
		int k = scn.nextInt();
		bt.RTL(k);

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

		public void RTL(int k) {
			ArrayList<Integer> list=new ArrayList<Integer>();
			RTL(root, k, 0,list);
			for(int i=list.size()-1;i>=0;i--) {
				System.out.print(list.get(i)+" ");
			}
		}

		private boolean RTL(Node node, int k, int sum,ArrayList<Integer> list) {
			if (node == null) {
				if(sum==k) {
					return true;
				}else {
					return false;
				}
			}

			boolean left=RTL(node.left, k, sum + node.data,list);
			boolean right=RTL(node.right, k, sum + node.data,list);

			if (left||right)
				list.add(node.data);
			
			return left||right;

		}
	}

}
