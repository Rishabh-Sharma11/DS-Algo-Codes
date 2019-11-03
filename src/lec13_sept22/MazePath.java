package lec13_sept22;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(mazePath(2,2,0,0,""));

	}
	public static int mazePath(int er,int ec,int cr,int cc,String ans) {
		if(cr==er&&cc==ec) {
			System.out.println(ans);
			return 1;
		}
		if(cr>er||cc>ec) {
			return 0;
		}
		 int cH=mazePath(er,ec,cr,cc+1,ans+'H');
		 int cV=mazePath(er,ec,cr+1,cc,ans+'V');
		 return cH+cV;
	}

}
