package lec13_sept22;

public class lexicographicalCountingprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 lexicoCounting(1000,0);

	}
	public static void lexicoCounting(int end,int curr) {
		if(curr>end) {
			return;
		}
		System.out.println(curr);
		
		int i=0;
		
		if(curr==0) {
			i=1;
		}
		
		while(i<10) {
			lexicoCounting(end,curr*10+i);
			i++;
		}
	}

}
