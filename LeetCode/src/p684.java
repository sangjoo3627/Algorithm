import java.util.*;

/*
 * Problem #684 Redundant Connection
 * 
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. 
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 * 
 * Example
 * 	Input: [[1,2], [1,3], [2,3]]
	Output: [2,3]
	Explanation: The given undirected graph will be like this:
	  1
	 / \
	2 - 3
 * 
 * 44%
 */

public class p684 {
	/*
	 * 접근방법
	 * undirected graph의 cycle을 판단하는 문제를 변형한 것
	 * union-find 자료구조를 쓰면 해당 두 노드가 같은 component에 있는 건지 판단할 수 있다
	 * 두 노드가 이미 같은 component에 있는데 두 노드를 잇는 edge가 있다면 cycle이라고 판단할수 있다.
	 * 즉 주어진 input인 모든 edge들을 DSU(Disjoint Set Union)에 union 함수로 넣으면서
	 * 동시에 cycle을 판단하면 바로 그 edge를 리턴한다
	 * 
	 * Time Complexity : O(n) (amortized)	[n은 number of vertices]
	 * Space Complexity : O(n)
	 */
	
	// Union-Find data structure
	public static class DSU {
		int [] parent;		// index가 자식, 저장된 값이 부모 (즉 index 값이 저장된 값을 가리키는 것)
		int [] rank;		// union-find ds에서 노드의 height
		
		public DSU(int size){
			parent = new int[size];
			for(int i=0; i<size; i++) parent[i] = i;
			rank = new int[size];
		}
		
		// find unique id which means it's root
		public int find(int x){
			if(parent[x] != x) parent[x] = find(parent[x]);
			return parent[x];
		}
		
		// merge two node depends on their ranks
		public boolean union (int x, int y){
			int xr = find(x), yr = find(y);
			// 두 노드의 root가 같다면, 즉 같은 component이면 이 edge는 cycle을 만든다는 것을 의미하므로 false 리턴
			if(xr == yr)
				return false;
			// rank가 더 높은 곳으로 연결해줘야 효율적
			else if(rank[xr] < rank[yr]) 
				parent[xr] = yr;
			else if(rank[xr] > rank[yr])
				parent[yr] = xr;
			else{
				parent[yr] = xr;
				rank[xr]++;
			}
			return true;
		}
	}

	public static int[] findRedundantConnection(int[][] edges) {
		DSU dsu = new DSU(1001);
		// 각 edge들의 vertex들을 union-find 자료구조에 저장하면서 cycle이 있으면 그 edge를 리턴
		for (int [] edge : edges){
			if(!dsu.union(edge[0], edge[1])) return edge;
		}
		throw new AssertionError();
    }
	
	public static void main(String[] args) {
		int [][] arr = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		System.out.println(Arrays.toString(findRedundantConnection(arr)));
	}

}


