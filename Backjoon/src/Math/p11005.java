/*
 * 진법변환 2
 */

package Math;
import java.util.*;
public class p11005 {

	public static String getValue(int n){
		char num = (char) ('7' + n);
		return Character.toString(num);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		String conv = "";
		
		while(N > 0){
			int temp = N;
			temp = temp%B;
			N = N/B;
			if(temp < 10) conv += temp;
			else conv += getValue(temp);
		}
		
		String result = new StringBuilder(conv).reverse().toString();
		System.out.println(result);
	}
	
	

}
