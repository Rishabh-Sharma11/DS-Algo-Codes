package assignment_Trees;

import java.util.Scanner;

public class BT_SumOfNodes {
static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		BT_SumOfNodes m = new BT_SumOfNodes();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.sumOfNodes());
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

		public int sumOfNodes() {
			return this.sumOfNodes(this.root) ;
		}
		
		private int sumOfNodes(Node node) {
			
			// write your code here
			if(node==null) {
				return 0;
			}
			int sum=node.data;
			sum+=sumOfNodes(node.left);
			sum+=sumOfNodes(node.right);
			return sum;
			
		}
	}

}
