import java.util.*;

public class Josep {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		CList list = new CList();
		for(int i=N; i>=1; i--)
			list.add(i);
		
		Node cur = list.header;
		
		System.out.print("<");
		
		while(!list.isEmpty()){
			for(int j=0; j<M; j++){
				cur = cur.next;
				if(cur == list.header)
					cur = cur.next;
			}
				
			System.out.print(cur.data);
			
			// delete
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			
			if(!list.isEmpty())
				System.out.print(", ");
		}
		
		System.out.print(">");
		
	}
	
	public static class Node {
		int data;
		Node next, prev;
		
		Node (){
			data = 0;
			next = null;
			prev = null;
		}
		
		Node (int x){
			data = x;
			prev = null;
			next = null;
		}
	}
	
	public static class CList {
		Node header;
		
		CList (){
			Node h = new Node();
			header = h;
			header.next = h;
			header.prev = h;
		}
		
		void add(int x){
			Node newnode = new Node (x);
			header.next.prev = newnode;
			newnode.next = header.next;
			newnode.prev = header;
			header.next = newnode;
		}
		
		boolean isEmpty(){
			return (header == header.next);
		}
	}
}


