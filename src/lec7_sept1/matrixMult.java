package lec7_sept1;

public class matrixMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]A= {{1,1},{1,1}};
		int[][]B= {{2,2},{2,2}};
		int[][] mult=matrixMultiplication(A,B);
		display(A);
		display(B);
		display(mult);

	}
	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] matrixMultiplication(int[][]one,int[][]two) {
		int r1=one.length;
		int c1=one[0].length;
		int r2=two.length;
		int c2=two[0].length;
		int[][] res=new int[r1][c2];
		for(int i=0;i<r1;i++) {
			for(int j=0;j<c2;j++) {
				for(int k=0;k<c1;k++) {
					res[i][j]+=one[i][k]*two[k][j];
				}
			}
		}
		return res;
	}

}
