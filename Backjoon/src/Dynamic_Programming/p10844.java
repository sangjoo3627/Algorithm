/*
 * 쉬운 계단수
 */

package Dynamic_Programming;
import java.util.*;
public class p10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long [][] d = new long [n+1][];
		for(int i=0; i<n+1; i++)
			d[i] = new long [10];
		
		d[1][0] = 0;
		for(int i=1; i<=9; i++)
			d[1][i] = 1;
		
		for(int i=2; i<=n; i++){
			for(int j=0; j<=9; j++){
				if(j==0) d[i][j] = d[i-1][j+1];
				else if(j==9) d[i][j] = d[i-1][j-1];
				else{
					d[i][j] = d[i-1][j+1] + d[i-1][j-1];
					d[i][j] %= 1000000000;
				}
			}
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++)
			ans += d[n][i];
		
		ans %= 1000000000;
		
		System.out.println(ans);
	}

}
