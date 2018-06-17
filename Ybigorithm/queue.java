import java.util.*;

public class queue {
	public static class Queue {
		ArrayList <Integer> list;
		
		Queue (){
			list = new ArrayList <Integer>();
		}
		
		void push (int x){
			list.add(x);
		}
		
		void pop (){
			if(list.isEmpty())
				System.out.println(-1);
			else
				System.out.println(list.remove(0));
		}
		
		void size (){
			System.out.println(list.size());
		}
		
		void empty(){
			if(list.isEmpty()) System.out.println(1);
			else System.out.println(0);
		}
		
		void printFront (){
			if(list.isEmpty()) System.out.println(-1);
			else System.out.println(list.get(0));
		}
		
		void printBack (){
			if(list.isEmpty()) System.out.println(-1);
			else System.out.println(list.get(list.size()-1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue q = new Queue ();
		
		for (int i=0; i<N; i++){
			String ins = sc.next();
			
			if(ins.equals("push")){
				int num = sc.nextInt();
				q.push(num);
			}
			else if(ins.equals("pop"))
				q.pop();
			else if(ins.equals("size"))
				q.size();
			else if(ins.equals("empty"))
				q.empty();
			else if(ins.equals("front"))
				q.printFront();
			else if(ins.equals("back"))
				q.printBack();
		}
		
		sc.close();

	}

}

