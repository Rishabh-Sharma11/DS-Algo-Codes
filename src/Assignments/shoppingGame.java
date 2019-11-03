package Assignments;

import java.util.Scanner;

public class shoppingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);
	        int T=scn.nextInt();
	        int M,N;
	        for(int i=0;i<T;i++){
	           M=scn.nextInt();
	           N=scn.nextInt();
	           if(M%2==0&&N%2==0){
	               if(M>N){
	                   System.out.println("Aayush");
	               }else if(M<N) {
	            	   System.out.println("Harshit");
	               }else {
	            	   System.out.println("Harshit");
	               }
	           }else if((M%2!=0&&N%2==0)||(M%2==0&&N%2!=0)){
	        	   if(M>N) {
	        		   System.out.println("Aayush");
	        	   }else{
	        		   System.out.println("Harshit");
	        	   }
	           }else{
	        	   if(M>N) {
	        		   System.out.println("Aayush");
	        	   }else if(M<N) {
	        		   System.out.println("Harshit");
	        	   }else {
	        		   System.out.println("Aayush");
	        	   }
	           }
	        }

	}

}
