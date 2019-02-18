import java.util.Scanner;

public class ex27_2 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int N, number, min, diff, col = 3, o = Integer.MAX_VALUE;
	static int data[][];	
	static int rows_mins[];	
	static long start, end;
	
	public static void main(String[] args) {		
		N = sc.nextInt();
		data = new int[col][N];
		rows_mins = new int[N];		
		for(int i=0; i<col*N; i++) {
			number = sc.nextInt();
			if (i>=3) {
				data[i%3][i/3] = number;
			}else{
				data[i][0] = number;
			}
		}
				
		for(int i=0; i<N; i++) {
			min = data[0][i];
			for(int k=1; k<3; k++) {
				if(data[k][i]<min) {
					min = data[k][i];
				}		
				rows_mins[i] = min;			
			}
		}
		
		int addition = add();
		if(addition%2 == 0) {			
			System.out.println(addition);			
		}else{				
			int address[] = new int[2];
			address[0] = -1;
			address[1] = -1;			
			
			for(int i=0; i<N; i++) {
				for(int k=0; k<3; k++) {	
					diff = data[k][i]-rows_mins[i];	
					if(diff>0 && diff%2==1 && data[k][i]<o) { 						
						o = data[k][i];
						address[0] = k;
						address[1] = i;
					}
				}
			}
			
			if(address[0]!=-1) {
				rows_mins[address[1]] = data[address[0]][address[1]];				
				System.exit(0);
			}else{
				fail();
			}
		}
		
	}	
	
	static int add() {
		int t = 0;
		for(int i=0; i<N; i++) {
			t += Math.pow(rows_mins[i], 2);
		}		
		
		return t;
	}
	
	static void fail() {
		System.out.println(0);
		System.exit(0);
	}
	
}
