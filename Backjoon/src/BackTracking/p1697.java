package BackTracking;
import java.util.*;

/*
 * Problem #1697 숨바꼭질
 * 
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * 24%
 */

public class p1697 {

	static boolean [] visit;
	static int shortest;
	
	public static class Node{
		int n;
		int t;
		
		Node (int n, int t){
			this.n = n;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		visit = new boolean[100000+1];
		Arrays.fill(visit, false);
		shortest = Integer.MAX_VALUE;
		
		Queue<Node> q = new LinkedList<>();
		Node a = new Node(N,0);
		q.add(a);
		
		while(!q.isEmpty()) {
			Node e = q.poll();
			
			if (e.n == K) {
				if(e.t < shortest) shortest = e.t;
			}
			
			visit[e.n] = true;
			
			if(e.n+1 >= 0 && e.n+1 <=100000 && !visit[e.n+1]) q.add(new Node(e.n+1, e.t+1));
			if(e.n-1 >= 0 && e.n-1 <=100000 && !visit[e.n-1]) q.add(new Node(e.n-1, e.t+1));
			if(e.n*2 >= 0 && e.n*2 <=100000 && !visit[e.n*2]) q.add(new Node(e.n*2, e.t+1));
		}
		
		System.out.println(shortest);
	}
	

}
