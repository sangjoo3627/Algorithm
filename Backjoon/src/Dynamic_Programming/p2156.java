/*
 * 포도주 시식
 */

package Dynamic_Programming;
import java.util.*;
public class p2156 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] p = new int [n+1];
		for(int i=1; i<=n; i++)
			p[i] = sc.nextInt();
		
		int [][] d = new int [n+1][];
		for(int i=1; i<=n; i++)
			d[i] = new int[2];
		
		d[1][0] = 0;
		d[1][1] = p[1];
		
		for(int i=2; i<=n; i++){
			if(i == 2){
				d[i][0] = d[i-1][1];
				d[i][1] = d[i-1][1] + p[i];
			}
			else{
				d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
				d[i][1] = Math.max(d[i-2][0]+p[i-1]+p[i], d[i-2][1]+p[i]);
			}
		}
		
		int ans = Math.max(d[n][0], d[n][1]);
		System.out.println(ans);
	}

}
