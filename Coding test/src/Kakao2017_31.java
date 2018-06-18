import java.util.*;
public class Kakao2017_31 {
	
	public static void solution(int n, int t, int m, int p){
		int lastNumber = m*(t-1) + p;
		
		String ans = "";
		ans += "0";
		
		for(int i=1;;i++){
			String now = calResult(n, i);
			ans += now;
			if(ans.length() > lastNumber) break;
		}
		
		for(int i=0; i<t; i++){
			System.out.print(ans.toString().charAt(p-1+(m*i)));
		}
		System.out.println();
	}

	public static String calResult(int n, int num){
		String result ="";
		
		int resultNum = num;
		while(resultNum > 0){
			int temp = resultNum;
			if(resultNum >= n)
				temp = resultNum%n;
			
			String tempResult = getValue(temp);
			result += tempResult;
			resultNum /= n;
		}
		
		String rev_result ="";
		for(int i=result.length()-1; i>=0; i--)
			rev_result += result.charAt(i);
		return rev_result;
	}
	
	public static String getValue(int num){
		switch(num){
		case 10 :
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		default:
			return String.valueOf(num);	
		}
	}
	
	public static void main(String[] args) {
		solution(2,4,2,1);
		solution(16,16,2,1);
		solution(16,16,2,2);
	}

}
