import java.util.*;

public class Tile2n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [] DP = new int[1001];
		DP[0] = 1;
		
		for(int i=1; i<=N; i++){
			if(i-1>=0)
				DP[i] += DP[i-1];
			if(i-2>=0)
				DP[i] += DP[i-2];
		}
		System.out.println(DP[N]%10007);

	}

}
