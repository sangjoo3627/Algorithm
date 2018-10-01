package Dynamic_Programming;
import java.util.*;

/*
 * Problem #14501 퇴사
 * 
 * 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
 * 오늘부터 N+1일째 되는날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
 * 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
 * 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
 * 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
 * 
 * 	입력
	첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
	둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
	
	출력
	첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
 * 
 * 44%
 */

public class p14501 {

	/*
	 * 꽤나 복잡한 다이나믹 프로그래밍 문제이다
	 * dp[i]는 i일에서의 최대 수익
	 * check[j]는 아직까지 P[j]이 사용되지 않은 날짜, 즉 T[j]이 전까지 기간이 채워지지않은경우
	 * 
	 * 각 i일에서 고려해야할 경우는 3가지이다 이 세가지 중 최대값을 dp[i]로 저장하면된다
	 * 첫번째, i일에 주어진 상담이 하루안에 끝나는 (T[i]==1)일 경우, ==>  dp[i-1]+P[i]
	 * 두번째, 하루안에 안끝날 경우, ==>  dp[i-1]
	 * 세번째, (0 ~ i-1)까지의 check[j]를 탐색해서 아직 체크안된 j일이 있고 j+T[j]-1 == i 라면 현재날짜부터 기간이 채워진다는 뜻이므로
	 *       j일의 P[j]도 고려하고 check[j]=true해준다  ==> dp[j-1]+P[j]
	 *       
	 * 구한 위의 세개 값중 가장 큰값을 dp[i]로 설정한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [] T = new int [N+1];
		int [] P = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		sc.close();
		
		int [] dp = new int[N+1];
		boolean [] check = new boolean[N+1];
		
		dp[0] = 0;
		
		// dp[i]는 i일까지의 최대 수익
		for(int i=1; i<=N; i++) {
			int max = 0;
			
			if(T[i] == 1) {
				check[i] = true;
				if(dp[i-1] + P[i] > max) max = dp[i-1] + P[i];
			}
			else {
				if(dp[i-1] > max) max = dp[i-1];
			}
			
			for(int j=i-1; j>0; j--) {
				if(!check[j] && j+T[j]-1 == i) { 
					if(dp[j-1] + P[j] > max) max = dp[j-1] + P[j];
					check[j] = true;
				}
			}
			
			dp[i] = max;
		}
		
		System.out.println(dp[N]);
	}

}
