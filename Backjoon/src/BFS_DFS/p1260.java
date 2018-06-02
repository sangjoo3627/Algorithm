/*
 * BFS, DFS 기본 구현 문제
 */

package BFS_DFS;

import java.util.*;

public class p1260 {

	static ArrayList<Integer>[] adj;
	static boolean[] c;
	
	public static void dfs(int x){
		c[x] = true;
		System.out.print(x + " ");
		for(int y : adj[x]){
			if(!c[y]) dfs(y);
		}
	}
	
	public static void bfs(int x){
		Queue <Integer> q = new LinkedList();
		c[x] = true;
		q.add(x);
		
		while(!q.isEmpty()){
			int e = q.remove();
			System.out.print(e + " ");
			for(int y : adj[e]){
				if(!c[y]){
					q.add(y);
					c[y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		adj = (ArrayList<Integer>[]) new ArrayList[N+1];
		for(int i=1; i<N+1; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for (int i=1; i<=N; i++) {
            Collections.sort(adj[i]);
        }
		
		c = new boolean[N+1];
		dfs(V);
		System.out.println();
		c = new boolean[N+1];
		bfs(V);
		System.out.println();
	}

}
