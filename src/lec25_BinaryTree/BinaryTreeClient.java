package lec25_BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "10 true 20 true 40 false false true 50 false false true 30 true 60 false false false";
		String str2 = "10 true 20 true 40 true 60 true 80 false false false false true 50 false true 70 false true 90 false false true 30 false false";
		BinaryTree bt = new BinaryTree(str);
//		BinaryTree bt=new BinaryTree(str2);
		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.height());
//		System.out.println(bt.find(60));
//		System.out.println(bt.diameter3());

//		System.out.println(bt.isBalanced2());

//		String str3="1 true 2 true 4 false false true 5 true 7 false false true 8 false false true 3 true 6 false ";
//		String str4="";
//		bt1.FlipEquivalent((bt2));

//		bt.PreOrder();
//		bt.PreOrderIteratively();

//		System.out.println(bt.MaxSubTreeSum3());

		int[] pre = { 10, 20, 40, 50, 30, 60, 70, 80 };
		int[] in = { 40, 20, 50, 10, 60, 30, 70, 80 };
		BinaryTree bt3 = new BinaryTree(pre, in);
		bt3.display();

		String str3 = "100 true 50 true 20 false false true 60 false false true 170 true 160 false false true 200 false false false";
		BinaryTree bt4 = new BinaryTree(str3);
		System.out.println(bt4.largestBST());

	}

}
