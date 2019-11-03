package lec23_oct20_GenericTree;

public class GTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
		
		String str="10 3 20 2 50 0 60 0 30 2 70 2 110 2 150 0 160 0 120 0 80 0 40 2 90 2 130 2 170 0 180 0 140 0 100 0";
		
		GenericTree gt=new GenericTree(str);
		gt.display();
//		System.out.println(gt.size());
//		System.out.println(gt.max());
//		System.out.println(gt.find(60));
//		gt.Mirror();
//		gt.display();
		
//		gt.Linearize();
//		gt.display();
		
//		gt.LevelOrder();
//		System.out.println();
		
		gt.LevelOrderLineWise2();
		System.out.println();
		gt.LevelOrderZigZag();
		

	}

}
