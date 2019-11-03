package lec26_BST;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in= {10,20,30,40,50,60};
		BST bst=new BST(in);
		bst.display();
//		System.out.println(bst.find(40));
//		System.out.println(bst.max());
//		
//		bst.printInRange(20, 50);
		
//		bst.replaceWithSumLarger();
//		bst.display();
		
//		bst.replaceWithSumLarger2();
//		bst.display();
		
		bst.add(45);
		bst.display();

	}

}
