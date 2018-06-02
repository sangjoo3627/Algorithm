/*
 * 진법변환
 */

package Math;
import java.util.*;
public class p2745 {

	public static int getValue(char n){
		if('0' <= n && n<='9') return n-'0';
		else return n-'A' + 10;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String N = sc.next();
		int B = sc.nextInt();
		
		int result = 0;
		int p = 0;
		
		for(int i=N.length()-1; i>=0; i--){
			char temp = N.charAt(i);
			double po = Math.pow(B, p++);
			int get = getValue(temp);
			result +=  po * get;
		}
		System.out.println(result);
	}

}
