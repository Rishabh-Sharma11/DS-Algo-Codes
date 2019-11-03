package lec9_sept8;

public class RecursionRulerInch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ruler(2,4,0);

	}
	public static void ruler(int inch,int ticklen,int count) {
		
		
		
		
		
	}
	public static void printTick(int ticklen) {
		if(ticklen==0) {
			System.out.println();
			return;
		}
		System.out.print("- ");
		printTick(ticklen-1);
	}
	public static void printTickNum(int ticklen,int count) {
		if(ticklen==0) {
			System.out.println(count++);
			return;
		}
		System.out.print("- ");
		printTickNum(ticklen-1,count);
	}

}
