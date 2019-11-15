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
		root = takeInput(new LinkedList<>());
	}

	private Node takeInput(Queue<Node> queue) {
		int item=scn.nextInt();
		if(item==-1) {
			return null;
		}
		Node nn=new Node();
		nn.data=item;
		queue.add(nn);
		nn.left=takeInput( queue);
		nn.right=takeInput( queue);
		queue.remove();
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
