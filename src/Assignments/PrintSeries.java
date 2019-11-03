package Assignments;

import java.util.Scanner;

public class PrintSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scn=new Scanner(System.in);
	        int N1=scn.nextInt();
	        int N2=scn.nextInt();
	         int k=1;
	        for(int i=1;i<=N1;i++){
	        	int mult=2;
	        	int flag=1;
	            int val=3*k+2;
	           
	            for(int j=N2;j<=val;mult++){
	                if(val%j==0){
	                    
	                    flag=0;
	                    break;
	                }
	                j=N2*mult;
	               
	            }
	            if(flag==1){
	                System.out.println(val);   
	            }
	            else {
	            	i--;
	            }
	             k++;
	                 
	        }

	}

}
