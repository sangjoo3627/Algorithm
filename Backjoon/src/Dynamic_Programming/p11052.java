/*
 * ºØ¾î»§ ÆÇ¸ÅÇÏ±â
 */

package Dynamic_Programming;
import java.util.*;
public class p11052 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] p = new int [1001];
		int [] d = new int [1001];
		
		for(int i=1; i<=n; i++)
			p[i] = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++)
				d[i] = Math.max(d[i], d[i-j]+p[j]);
		}
		
		System.out.println(d[n]);
	}

}
