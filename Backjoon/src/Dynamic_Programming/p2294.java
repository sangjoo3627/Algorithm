/*
 *  ����2
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
		
		// d[i]�� i���� ����µ� ������ �ּ� ����
		for(int i=1; i<=k; i++){
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=n; j++){
				if(i>=a[j] && d[i-a[j]] < min){
					// 0�� �϶��� ok, but �ּ� ������ 0���϶��� �����ö� pass
					if(d[i-a[j]] != 0 || i-a[j] == 0){
						d[i] = d[i-a[j]] + 1;
						min = d[i-a[j]];
					}
				}
			}
		}
		
		// �ּ� ������ 0�� ���� -1�� ��ü
		for(int i=1; i<=k; i++)
			if(d[i] == 0) d[i] = -1;
		
		System.out.println(d[k]);

	}

}
