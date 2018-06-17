import java.util.*;

public class Deque {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Vector <Integer> list = new Vector<Integer>();
		
		for(int i=0; i<N; i++){
			String ins = sc.next();
			
			if(ins.equals("push_front")){
				int n = sc.nextInt();
				list.add(0, n);
			}
			else if(ins.equals("push_back")){
				int n = sc.nextInt();
				list.add(n);
			}
			else if(ins.equals("pop_front")){
				if(list.isEmpty()) System.out.println(-1);
				else{
					System.out.println(list.firstElement());
					list.remove(0);
				}
			}
			else if(ins.equals("pop_back")){
				if(list.isEmpty()) System.out.println(-1);
				else{
					System.out.println(list.lastElement());
					list.remove(list.size()-1);
				}
			}
			else if(ins.equals("size")){
				System.out.println(list.size());
			}
			else if(ins.equals("empty")){
				if(list.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(ins.equals("front")){
				if(list.isEmpty()) System.out.println(-1);
				else System.out.println(list.firstElement());
			}
			else if(ins.equals("back")){
				if(list.isEmpty()) System.out.println(-1);
				else System.out.println(list.lastElement());
			}
		}

	}

}
