import java.util.*;

public class add123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		
		for (int i=0 ; i<N; i++){
			int num = sc.nextInt();
			
			int [] DP = new int [11];
			DP[0] = 1;
			
			for(int j=1; j<=num; j++){
				if(j-1 >= 0)
					DP[j] += DP[j-1];
				if(j-2 >= 0)
					DP[j] += DP[j-2];
				if(j-3 >= 0)
					DP[j] += DP[j-3];
			}
			System.out.println(DP[num]);
		}
	}

}
