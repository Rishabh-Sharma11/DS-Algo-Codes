package lec33_nov10_DynamicPragramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap = 7;

//		System.out.println(knapSackNegativeBaseCase2(wt, price, cap, 0));
//		System.out.println(knapSackNegativeBaseCase(wt, price, cap, 0, false));
		
		
		System.out.println(knapSackBottomUp(wt, price, cap));


//		System.out.println(fracKnapSack(wt, price, cap));

	}

	// ---------------------------------------------------------------------------------
	// 0-1 KnapSack
	// Dynamic Pragramming
	// ---------------------------------------------------------------------------------

	public static int knapSack(int[] wt, int[] price, int cap, int vidx) {
		if (vidx == wt.length) {
			return 0;
		}

		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapSack(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		}
		int exclude = knapSack(wt, price, cap, vidx + 1);

		return Math.max(include, exclude);
	}

	public static int knapSackNegativeBaseCase(int[] wt, int[] price, int cap, int vidx, boolean isIncluded) {
		if (cap < 0) {
			if (isIncluded)
				return -price[vidx - 1];
			else
				return 0;
		}
		if (vidx == wt.length) {
			return 0;
		}

		int include = knapSackNegativeBaseCase(wt, price, cap - wt[vidx], vidx + 1, true) + price[vidx];
		int exclude = knapSackNegativeBaseCase(wt, price, cap, vidx + 1, false);

		return Math.max(include, exclude);
	}

	public static int knapSackNegativeBaseCase2(int[] wt, int[] price, int cap, int vidx) {
		if (cap < 0) {
			return Integer.MIN_VALUE;
		}

		if (vidx == wt.length) {
			return 0;
		}

		int include = knapSackNegativeBaseCase2(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		int exclude = knapSackNegativeBaseCase2(wt, price, cap, vidx + 1);

		return Math.max(include, exclude);
	}

	public static int knapSackTopDown(int[] wt, int[] price, int cap, int vidx, int[][] storage) {
		if (vidx == wt.length) {
			return 0;
		}
		if(storage[vidx][cap]!=-1) {
			return storage[vidx][cap];
		}

		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapSackTopDown(wt, price, cap - wt[vidx], vidx + 1, storage) + price[vidx];
		}
		int exclude = knapSackTopDown(wt, price, cap, vidx + 1, storage);

		return storage[vidx][cap] = Math.max(include, exclude);
	}
	
	public static int knapSackBottomUp(int[] wt,int[] price,int cap) {
		int[][] storage=new int[wt.length+1][cap+1];
		for(int row=wt.length-1;row>=0;row--) {
			for(int col=cap;col>=1;col--) {
				int include = 0;
				if (col >= wt[row]) {
					include =storage[row+1][col-wt[row]]+price[row];
				}
				int exclude =storage[row+1][col];
				
				storage[row][col]=Math.max(include, exclude);
			}
		}
		
		return storage[0][cap];
	}

	// ---------------------------------------------------------------------------------
	// Fractional KnapSack
	// Greedy Algorithm
	// ---------------------------------------------------------------------------------

	static class Pair implements Comparator<Pair>{
        int w;
        int p;
        public Pair() {}
        public Pair(int w, int p){
            this.w = w;
            this.p = p;
        }
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.p/o2.w - o1.p/o1.w;   // for descending order of price/weight ratio
        }
        @Override
        public String toString() {
            String str = "Weight = " + this.w + " and Price = " + this.p;
            return str;
        }
    }
    public static float fracKnapSack(int[] wt, int[] price, int cap){
        float ans = 0;
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0; i<wt.length; i++){
            Pair obj = new Pair(wt[i], price[i]);
            al.add(obj);
        }
        Collections.sort(al, new Pair());
        for(Pair val: al){
            System.out.println(val);
        }
        for(int i = 0; i<al.size(); i++){
            
            if(cap<=0){
                break;
            }else if(cap >= al.get(i).w){
                cap = cap - al.get(i).w;
                ans += al.get(i).p;
            }else{
                float frac = (float)cap/al.get(i).w;
                System.out.println("Frac="+frac);
                ans += frac * al.get(i).p;
            }
            
        }
        return ans;
    }


}
