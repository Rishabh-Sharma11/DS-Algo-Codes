package assignment_Trees;

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
		root = takeInput(false);
	}

	private Node takeInput(boolean isleft) {
		int item = scn.nextInt();
		if (item != -1) {
			Node nn = new Node();
			nn.data = item;
			if(isleft) {
				nn.left=takeInput(!isleft);
			}else {
			nn.right=takeInput(!isleft);
			}
			
			return nn;
		}
		return null;
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
	
	public void printLeafNodes() {
		printLeafNodes(root);
	}

	private void printLeafNodes(Node node) {
		if(node.left==null&&node.right==null) {
			System.out.print(node.data+" ");
			return;
		}
		if(node.left==null||node.right==null) {
			return;
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);
		
	}
	
	public static void main(String[] args) {
		BT_PrintAllLeafNodes obj=new BT_PrintAllLeafNodes();
		obj.printLeafNodes();
		obj.display();
	}

}
