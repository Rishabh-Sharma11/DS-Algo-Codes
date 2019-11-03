package lec14_sept29Backtracking;

public class QueenCombinationBoxRespect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queenCombinationBoxRespect(new boolean[4], 0, 2, 0, "", 0);
		
	}
	public static int queenCombinationBoxRespect(boolean[]boxes,int col,int tq,int qpsf,String ans,int count) {
		if(qpsf==tq) {
			System.out.println(++count+". "+ans);
			return count;
		}
		if(col==boxes.length) {
			 return count;
		}
		
		//Queen Placed
		boxes[col]=true;
		count=queenCombinationBoxRespect(boxes, col+1, tq, qpsf+1, ans+"b"+col+" ",count);
		boxes[col]=false;
		//not placed
		count=queenCombinationBoxRespect(boxes, col+1, tq, qpsf, ans,count);
		return count;
	}

}
