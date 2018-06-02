/*
 * µ¿Àü 0
 */
package Greedy;
import java.util.*;
public class p11047 {
	
	static int [] a = new int [11];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int max = 0;
		int max_ind = 0;
		
		for(int i=1; i<=N; i++){
			a[i] = sc.nextInt();
			if(a[i] <= K && a[i] > max)	{
				max = a[i];
				max_ind = i;
			}
		}
		
		int ans = 0;
		int rest = K;
		
		for(int i=max_ind; i>=1; i--){
			while(rest >= a[i]){
				rest = rest - a[i];
				ans++;
			}
			if(rest == 0) break;
		}
		
		System.out.println(ans);
	}

}
