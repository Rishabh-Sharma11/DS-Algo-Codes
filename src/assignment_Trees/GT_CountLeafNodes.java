package assignment_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GT_CountLeafNodes {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		GT_CountLeafNodes m = new GT_CountLeafNodes();
		GenericTree gt = m.new GenericTree();
		System.out.println(gt.countLeafNodes());
	}

	private class GenericTree {
		private class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();
		}

		private Node root;

		public GenericTree() {
			this.root = this.takeInput(scn, null, -1);
		}

		private Node takeInput(Scanner scn, Node parent, int i) {

			int childData = scn.nextInt();

			int numGC = scn.nextInt();

			Node child = new Node();
			child.data = childData;

			for (int j = 0; j < numGC; j++) {
				Node gc = this.takeInput(scn, child, j);
				child.children.add(gc);
			}

			return child;
		}

		public int countLeafNodes() {
			return this.countLeafNodes(this.root);
		}

		private int countLeafNodes(Node node) {

			// write your code here
			if(node.children.size()==0) {
				return 1;
			}
			int count=0;
			for(Node child:node.children) {
				count+=countLeafNodes(child);
			}
			return count;
		}
	}


}
