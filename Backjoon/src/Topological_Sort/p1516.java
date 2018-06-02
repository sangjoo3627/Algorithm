/*
 * ���� ���� 
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
				 * ��������Ʈ : �������� ������ ������
				 * �������� ��������Ʈ�� ¥�ߵǴµ� �� ������ ��ǲ�� �����ϴ� ��������
				 * �־����Ƿ� index�� �ݴ�� �Ͽ� ��������Ʈ�� ����
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
				 * �������� ������ �ϳ��� queue���� �����ϸ鼭 ans[]�� ���
				 * �����ִ� build[]�� cost�� ������ ���� ������ ans[]�� ���� ����
				 * ���� ans[] ���� ���Ͽ� ���� ū���� ���Ѵ�.
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
