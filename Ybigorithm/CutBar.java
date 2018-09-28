import java.util.*;

/*
 * Problem #10799 쇠막대기
 * 
 * 괄호로 입력을 받아 레이져 "()"에 잘린 쇠막대기의 잘린 조각의 개수 구하기
 */


public class CutBar {
	
	/*
	 * '('가 나오면 스택에 넣고, ')'가 나오면 바로 전의 입력을 확인후
	 * 바로전이 '('였으면 레이저라 판단하고 결과값에 +=stack.size를 취한다
	 * 레이저가 아니라면 쇠막대기의 끝을 나타내므로 잘린 마지막 부분을 더한다 result++;
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String input = sc.nextLine();
		sc.close();
		
		int result = 0;
		
		Stack <Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			char cur = input.charAt(i);
			if(cur == '(') {
				if(input.charAt(i+1) != ')')
					stack.push(cur);
			}
			else if(cur == ')') {
				if(input.charAt(i-1) == '(') result += stack.size();
				else {
					stack.pop();
					result++;
				}
				
			}
		}
		System.out.println(result);
	}

}
