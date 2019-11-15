package assignment_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BT_PrintAllLeafNodes {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	Scanner scn = new Scanner(System.in);

	public BT_PrintAllLeafNodes() {
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

//	 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

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

	public void printLeafNodes() {
		printLeafNodes(root);
	}

	private void printLeafNodes(Node node) {
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		if (node.left == null || node.right == null) {
			return;
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);

	}

	public static void main(String[] args) {
		BT_PrintAllLeafNodes obj = new BT_PrintAllLeafNodes();
		obj.printLeafNodes();
		obj.display();
	}

}
