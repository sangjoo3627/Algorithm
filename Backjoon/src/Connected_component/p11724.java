/*
 * Problem #11724 연결요소의 개수
 * 
 * Connected Component 기본 구현 문제
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * 
	입력
	첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
	
	출력
	첫째 줄에 연결 요소의 개수를 출력한다.
 */
package Connected_component;

import java.util.*;

public class p11724 {

	static ArrayList<Integer> [] adj;
	static boolean [] c;
	
	public static void dfs(int x){
		c[x] = true;
		for(int y : adj[x]){
			if(!c[y]) dfs(y);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		c = new boolean[n+1];
		adj = new ArrayList [n+1];
		for(int i=0; i<n+1; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adj[v].add(u);
			adj[u].add(v);
		}
		
		int result=0;
		dfs(1);
		result++;
		
		for(int i=1; i<n+1; i++){
			if(!c[i]){
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}

}
