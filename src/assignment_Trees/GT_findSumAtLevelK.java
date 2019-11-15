package assignment_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GT_findSumAtLevelK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GT_findSumAtLevelK obj = new GT_findSumAtLevelK();
		GenericTree gt = obj.new GenericTree();
		int k = scn.nextInt();
		System.out.println(gt.sumAtLevelK(k));

	}

	static Scanner scn = new Scanner(System.in);

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

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			// work
			String str = node.data + " => ";
			for (Node child : node.children) {
				str += child.data + ", ";
			}
			System.out.println(str + "END");

			// delegate
			for (Node child : node.children) {
				this.display(child);
			}
		}

		public int sumAtLevelK(int k) {
			return sumAtLevelK(this.root, k, 0);
		}

		private int sumAtLevelK(Node node, int k, int level) {
			if (level == k) {
				return node.data;
			}
			int sum = 0;
			for (Node child : node.children) {
				sum += sumAtLevelK(child, k, level + 1);
			}
			return sum;
		}
	}

}
