/*
 * 게임 개발 
 */

package Topological_Sort;

import java.util.*;
import java.lang.Math.*;

public class p1516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// variables
		int num = Integer.parseInt(sc.nextLine());
		Queue<Integer> queue = new LinkedList<>();
		int [] indeg = new int[num+1];
		int [] build = new int[num+1];
		int [] ans = new int [num+1];
		
		ArrayList <Integer>[] adj = new ArrayList[num+1];
		for(int i=0; i<num+1; i++)
			adj[i] = new ArrayList<Integer>();
		
		// set value
		for(int i=1; i<num+1; i++){
			build[i] = sc.nextInt();
			while(true){
				int next = sc.nextInt();
				if(next == -1) break;
				indeg[i]++;
				/* 
				 * 인접리스트 : 정점에서 나가는 간선을
				 * 기준으로 인접리스트를 짜야되는데 이 문제의 인풋은 진입하는 정점으로
				 * 주어지므로 index를 반대로 하여 인접리스트를 생성
				 */ 
				adj[next].add(i);
			}
		}
		
		// algorithm
		for(int i=1; i<num+1;i++){
			if(indeg[i] == 0){
				queue.add(i);
				ans[i] = build[i];
			}
		}

		while(!queue.isEmpty()){
			int nedge = queue.poll();
			for(int i=0; i<adj[nedge].size(); i++){
				int e = adj[nedge].get(i);
				/*
				 * 위상정렬 순으로 하나씩 queue에서 제거하면서 ans[]을 계산
				 * 원래있는 build[]의 cost와 그전의 선행 정점의 ans[]를 더한 값과
				 * 현재 ans[] 값과 비교하여 제일 큰값을 취한다.
				 */
				ans[e] = Math.max(ans[e], build[e]+ans[nedge]);
				if(--indeg[e] == 0)
					queue.add(e);
			}
		}
		
		// Print result
		for(int i=1; i<num+1; i++)
			System.out.println(ans[i]);
		
		/*
		  for(int i=1; i<num+1; i++)
		  System.out.println(indegStr[i]);
		*/
		 
	}

}
