package BackTracking;
import java.util.*;

/*
 * Problem #1697 ���ٲ���
 * 
 * �����̴� ������ ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, ������ �� K(0 �� K �� 100,000)�� �ִ�. 
 * �����̴� �Ȱų� �����̵��� �� �� �ִ�. ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.
 * �����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
