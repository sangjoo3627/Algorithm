/*
 * 2 X n 타일 채우기2 (1X2, 2X1, 2X2 타일)
 */

package Dynamic_Programming;

import java.util.*;

public class p11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] d = new int[1001];
		
		d[0] = 1;
		d[1] = 1;
		d[2] = 3;
		for(int i=3; i<=n; i++){
			d[i] = 2*d[i-2] + d[i-1];
			d[i] %= 10007;
		}
			
		System.out.println(d[n]);
	}

}
