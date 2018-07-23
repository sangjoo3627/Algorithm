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
	 * ���ٹ��
	 * undirected graph�� cycle�� �Ǵ��ϴ� ������ ������ ��
	 * union-find �ڷᱸ���� ���� �ش� �� ��尡 ���� component�� �ִ� ���� �Ǵ��� �� �ִ�
	 * �� ��尡 �̹� ���� component�� �ִµ� �� ��带 �մ� edge�� �ִٸ� cycle�̶�� �Ǵ��Ҽ� �ִ�.
	 * �� �־��� input�� ��� edge���� DSU(Disjoint Set Union)�� union �Լ��� �����鼭
	 * ���ÿ� cycle�� �Ǵ��ϸ� �ٷ� �� edge�� �����Ѵ�
	 * 
	 * Time Complexity : O(n) (amortized)	[n�� number of vertices]
	 * Space Complexity : O(n)
	 */
	
	// Union-Find data structure
	public static class DSU {
		int [] parent;		// index�� �ڽ�, ����� ���� �θ� (�� index ���� ����� ���� ����Ű�� ��)
		int [] rank;		// union-find ds���� ����� height
		
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
			// �� ����� root�� ���ٸ�, �� ���� component�̸� �� edge�� cycle�� ����ٴ� ���� �ǹ��ϹǷ� false ����
			if(xr == yr)
				return false;
			// rank�� �� ���� ������ ��������� ȿ����
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
		// �� edge���� vertex���� union-find �ڷᱸ���� �����ϸ鼭 cycle�� ������ �� edge�� ����
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


