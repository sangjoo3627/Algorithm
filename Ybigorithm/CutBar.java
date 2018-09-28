import java.util.*;

/*
 * Problem #10799 �踷���
 * 
 * ��ȣ�� �Է��� �޾� ������ "()"�� �߸� �踷����� �߸� ������ ���� ���ϱ�
 */


public class CutBar {
	
	/*
	 * '('�� ������ ���ÿ� �ְ�, ')'�� ������ �ٷ� ���� �Է��� Ȯ����
	 * �ٷ����� '('������ �������� �Ǵ��ϰ� ������� +=stack.size�� ���Ѵ�
	 * �������� �ƴ϶�� �踷����� ���� ��Ÿ���Ƿ� �߸� ������ �κ��� ���Ѵ� result++;
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
