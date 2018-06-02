/*
 * ¹®Á¦Áý
 */

package Topological_Sort;

import java.util.*;

public class p1766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int M = sc.nextInt();
		
		PriorityQueue <Integer> q = new PriorityQueue<>();
		int [] indeg = new int [num+1];
		ArrayList <Integer>[] adj = new ArrayList[num+1];
		for(int i=0; i<num+1; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++){
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// set indegree 
			indeg[B]++;
			// adj list
			adj[A].add(B);
		}
		
		for(int i=1; i<num+1; i++)
			if(indeg[i] == 0) q.add(i);
		
		while(!q.isEmpty()){
			int nedge = q.remove();
			System.out.print(nedge + " ");
			
			for(int i=0; i<adj[nedge].size(); i++){
				int e = adj[nedge].get(i);
				if(--indeg[e] == 0) q.add(e);
			}
		}
	}

}
