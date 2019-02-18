package use;

import java.util.Scanner;

public class Start {

	static int N, res;	
	static int[] nums;
  
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		N = sc.nextInt();
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i=0; i<=N-5; i++) {
			int takeFrom = i+4;
			while(takeFrom <= N-1) {
				if(i*nums[takeFrom]%29 == 0) {
					res++;
				}
				takeFrom++;
			}			
		}
		System.out.println(res);
	}	
}
