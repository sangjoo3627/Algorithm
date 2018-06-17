import java.util.*;

public class VPS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		Loop1:for(int i=0; i<num; i++)
		{
			String s = scan.next();
			Stack <Character> stack = new Stack<Character>();
			
			for (int j=0; j<s.length(); j++)
			{
				char temp = s.charAt(j);
				
				if(temp =='(')
					stack.push(temp);
				else if(temp ==')')
				{
					if(stack.isEmpty()){
						System.out.println("NO");
						continue Loop1;
					}
					else
						stack.pop();
				}
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
