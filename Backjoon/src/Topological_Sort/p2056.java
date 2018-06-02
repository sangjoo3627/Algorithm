/*
 *  ÀÛ¾÷
 */
package Topological_Sort;

import java.util.*;

public class p2056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		
		Queue <Integer> q = new LinkedList();
		int [] cost = new int [num+1];
		int [] indeg = new int [num+1];
		int [] result = new int [num+1];
		
		ArrayList<Integer> [] adj = new ArrayList[num+1];
		for(int i=0; i<num+1; i++)
			adj[i] = new ArrayList();
		
		for(int i=1; i<num+1; i++){
			cost[i] = sc.nextInt();
			int preNum = sc.nextInt();
			
			for(int j=0; j<preNum; j++){
				indeg[i]++;
				int prev = sc.nextInt();
				adj[prev].add(i);
			}
		}
		
		for(int i=1; i<num+1; i++){
			if(indeg[i] == 0){
				q.add(i);
				result[i] = cost[i];
			}
		}

		while(!q.isEmpty()){
			int nedge = q.remove();
			
			for(int i=0; i<adj[nedge].size(); i++){
				int e = adj[nedge].get(i);
				
				result[e] = Math.max(result[e], result[nedge]+cost[e]);
				
				if(--indeg[e] == 0) q.add(e);
			}
		}
		
		int ans = 0;
		for(int i=1; i<num+1; i++)
			//System.out.println(result[i]);
			ans = Math.max(ans, result[i]);
		
		System.out.println(ans);
	}

}
