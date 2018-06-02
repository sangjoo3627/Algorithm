/*
 *  동전2
 */

package Dynamic_Programming;
import java.util.*;
public class p2294 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] a = new int [101];
		int [] d = new int [10001];
		
		for(int i=1; i<=n; i++)
			a[i] = sc.nextInt();
		
		d[0] = 0;
		
		// d[i]는 i원을 만드는데 동전의 최소 개수
		for(int i=1; i<=k; i++){
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=n; j++){
				if(i>=a[j] && d[i-a[j]] < min){
					// 0원 일때는 ok, but 최소 개수가 0개일때를 가져올땐 pass
					if(d[i-a[j]] != 0 || i-a[j] == 0){
						d[i] = d[i-a[j]] + 1;
						min = d[i-a[j]];
					}
				}
			}
		}
		
		// 최소 개수가 0인 경우는 -1로 대체
		for(int i=1; i<=k; i++)
			if(d[i] == 0) d[i] = -1;
		
		System.out.println(d[k]);

	}

}
