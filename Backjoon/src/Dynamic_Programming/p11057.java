/*
 * 오르막 수
 */

package Dynamic_Programming;
import java.util.*;
public class p11057 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		long [][] d = new long [n+1][];
		for(int i=0; i<=n; i++)
			d[i] = new long [10];
		
		// 초기값 설정
		for(int i=0; i<=9; i++)
			d[1][i] = 1;
		
		for(int i=2; i<=n; i++){
			for(int j=9; j>=0; j--){
				for(int k=j; k>=0; k--) {
					d[i][j] += d[i-1][k];
					d[i][j] %= 10007;
				}
			}
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++){
			ans += d[n][i];
			ans %= 10007;
		}
		
		System.out.print(ans);
	}

}
