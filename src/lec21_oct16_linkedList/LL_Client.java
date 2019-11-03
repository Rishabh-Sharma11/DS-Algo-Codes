package lec21_oct16_linkedList;

public class LL_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);
		list.addLast(90);
		
//		list.addLast(60);
		
		list.display();
//		list.addFirst(70);
//		
//		list.addAt(list.size(),80);
		
//		list.display();
		
//		System.out.println(list.removeFirst());
//		list.display();
//		
//		System.out.println(list.removeLast());
//		list.display();
//		
//		System.out.println(list.removeAt(2));
//		list.display();
		
//		System.out.println("Reverse");
//		list.RDI();
//		list.RPI();
//		list.RPR();
//		list.RDR();
//		list.display();
		
//		list.Fold();
//		list.display();
		
//		System.out.println(list.Mid());
		
//		System.out.println(list.kFromLast(4));
		
//		System.out.println(list.createDummyListForIntersection());
		
		list.kReverse(3);
		list.display();
		
	}

}
