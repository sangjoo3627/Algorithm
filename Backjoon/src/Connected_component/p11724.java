/*
 * Connected Component 기본 구현 문제
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
