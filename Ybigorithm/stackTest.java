import java.io.*;
import java.lang.*;
import java.util.*;

public class stackTest {
	public static class Stack {
		private int top;
		private ArrayList<Integer> list;
		
		Stack (){
			top = -1;
			list = new ArrayList<Integer>();
		}
		
		public void push (int num){
			list.add(num);
			top += 1;
		}
		
		public void pop (){
			if(list.isEmpty())
				System.out.println(-1);
			else 
			{
				int t = list.remove(list.size()-1);
				System.out.println(t);
			}
		}
		
		public void size (){
			System.out.println(list.size());
		}
		
		public void empty(){
			if(list.isEmpty())
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		public void top (){
			if (list.isEmpty())
				System.out.println(-1);
			else
				System.out.println(list.get(list.size()-1));
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		Stack stack = new Stack();
		
		for (int i=0; i<num; i++){
			String s = scan.next();
			if(s.equals("push"))
			{
				int n = scan.nextInt();
				stack.push(n);
			}
			else if(s.equals("pop"))
				stack.pop();
			else if(s.equals("size"))
				stack.size();
			else if(s.equals("empty"))
				stack.empty();
			else if(s.equals("top"))
				stack.top();
		}
		
		
	}

}
