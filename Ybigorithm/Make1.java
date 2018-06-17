import java.util.*;

public class Make1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		
		int [] DP = new int [N+1];
		
		for(int i=2; i<=N; i++){
			ArrayList <Integer> list = new ArrayList <Integer>();
			
			if(i%3 == 0){
				list.add(DP[i/3] + 1);
			}
			if(i%2 == 0){
				list.add(DP[i/2] + 1);
			}
			
			list.add(DP[i-1] + 1);
			DP[i] = Collections.min(list);
		}
		
		System.out.println(DP[N]);
		
	}

}
