package lec23_oct20_GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
//	Scanner scn = new Scanner(System.in);
	Scanner scn;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree(String input) {
		scn = new Scanner(input);
		root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {
		// give prompt to user
		if (parent == null) {
			System.out.println("Enter the data for root element?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}
		// take input
		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println("Enter the number of children of " + nn.data);
		int noc = scn.nextInt();
		for (int i = 0; i < noc; i++) {
			Node child = takeInput(nn, i);
			nn.children.add(child);
		}
		return nn;

	}

	public void display() {
		System.out.println("-----------------------------------------");
		display(root);
		System.out.println("-----------------------------------------");
	}

	private void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ",";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int ts = 0;
		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = max(child);
			max = Math.max(max, cmax);
		}
		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int th = -1;
		for (Node child : node.children) {
			int ch = height(child);
			if (ch > th) {
				th = ch;
			}
		}
		return th + 1;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node.data == item) {
			return true;
		}
		boolean res = false;
		for (Node child : node.children) {

			res = res || find(child, item);

		}
		return res;

	}

	private boolean find2(Node node, int item) {
		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find2(child, item);
			if (cf) {
				return true;
			}

		}
		return false;

	}

	public void Mirror() {
		Mirror(root);
	}

	private void Mirror(Node node) {
		// array list reversed
		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {
			Node ln = node.children.get(left);
			Node rn = node.children.get(right);
			Node temp = ln;
			node.children.set(left, rn);
			node.children.set(right, temp);

			left++;
			right--;
		}
		// or simply use Collections.reverse(node.children);
		// smaller problem
		for (Node child : node.children) {
			Mirror(child);
		}
	}

	public void Linearize() {
		Linearize(root);
	}

	private void Linearize(Node node) {
		if (node.children.size() == 0) {
			return;
		}

		for (Node child : node.children) {
			Linearize(child);
		}

		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}

	}

	private Node getTail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));
	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {
		if (count == level) {
			System.out.println(node.data);
			return;
		}
		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	public void Preorder() {
		Preorder(root);
	}

	private void Preorder(Node node) {
		System.out.println(node.data);

		for (Node child : node.children) {
			Preorder(child);
		}

	}

	public void Postorder() {
		Postorder(root);
	}

	private void Postorder(Node node) {

		for (Node child : node.children) {
			Postorder(child);
		}
		System.out.println(node.data);

	}

	public void LevelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			for (Node child : rn.children) {
				queue.add(child); // adds at last
			}
		}

	}

	public void LevelOrderLineWise() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.add(root);
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");
			for (Node child : rn.children) {
				helper.add(child); // adds at last
			}

			if (primary.isEmpty()) {
				System.out.println();
				LinkedList<Node> temp = primary;
				primary = helper;
				helper = temp;
			}
		}
	}

	public void LevelOrderLineWise2() { 
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.addLast(root);

		while (!primary.isEmpty()) {

			Node rn = primary.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				primary = helper;
				helper = new LinkedList<>();

				System.out.println();
			}

		}
	}

	public void LevelOrderZigZag() {
		int count = 0;

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {
				queue = stack;
				stack = new LinkedList<>();

				System.out.println();

				count++;
			}

		}
	}

}
