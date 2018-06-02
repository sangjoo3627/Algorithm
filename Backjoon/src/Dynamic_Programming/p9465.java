/*
 * 스티커 떼기
 */

package Dynamic_Programming;
import java.util.*;
public class p9465 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			int n = sc.nextInt();
			
			int [][] map = new int[2][];
			map[0] = new int [n+1];
			for(int p=1; p<=n; p++)
				map[0][p] = sc.nextInt();
			
			map[1] = new int [n+1];
			for(int p=1; p<=n; p++)
				map[1][p] = sc.nextInt();
			
			int [][] d = new int [n+1][];
			for(int p=1; p<=n; p++)
				d[p] = new int [3];
			
			d[1][0] = map[0][1];
			d[1][1] = map[1][1];
			d[1][2] = 0;
			
			// d[j][0]은 첫번째줄 뗏을때, d[j][1]은 두번째줄 뗏을때, d[j][2]는 둘다 안뗏을때
			// 얻을 수 있는 최대 점수 (j번째 열에서) 
			for(int j=2; j<=n; j++){
				d[j][0] = Math.max(d[j-1][1] + map[0][j], d[j-1][2] + map[0][j]);
				d[j][1] = Math.max(d[j-1][0] + map[1][j], d[j-1][2] + map[1][j]);
				d[j][2] = Math.max(d[j-1][0], d[j-1][1]);
			}
			int ans = Math.max(d[n][0], d[n][1]);
			System.out.println(ans);
		}
	}

}
