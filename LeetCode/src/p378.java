import java.util.*;

/*
 * Problem #378 Kth Smallest Element in a Sorted Matrix
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:

	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	
	return 13.
 * 
 * 45%
 */

public class p378 {
	
	/*
	 * 나의 접근방법:
	 * merge sort에서 merge 부분을 이용한다
	 * 맨윗 row부터 하나씩 merge하면서 하나의 배열 merge[]로 만든후, merge[k-1]을 출력한다
	 * 시간복잡도 : O(n^2)
	 * 
	 * Discuss의 방법들
	 * 
	 * 1. Heap을 이용한다
	 * PriorityQueue를 사용해서 첫 row의 값들을 모두 pq에 집어넣고 min값을 꺼내면서 이값의 다음 컬럼값을 pq에 넣는방식
	 * 꽤나 획기적인 방법이라 생각했으나 걸리는 시간은 생각보다 많이 줄지 않았음
	 */
	 /* public class Solution {
		    public int kthSmallest(int[][] matrix, int k) {
		        int n = matrix.length;
		        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
		        for(int i = 0; i < k-1; i++) {
		            Tuple t = pq.poll();
		            if(t.x == n-1) continue;
		            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
		        }
		        return pq.poll().val;
		    }
		}
		
		class Tuple implements Comparable<Tuple> {
		    int x, y, val;
		    public Tuple (int x, int y, int val) {
		        this.x = x;
		        this.y = y;
		        this.val = val;
		    }
		    
		    @Override
		    public int compareTo (Tuple that) {
		        return this.val - that.val;
		    }
		}
	 */ 
	
	 /* 2. Binary Search 방법 O(nlog(max-min))
	 * 2차원배열의 binary search이다, matrix[0][0]과 matrix[n-1][n-1] 값을 시작으로 탐색하는데
	 * 여기서 내가 생각했던 것과 다른점은
	 * 이 값들이 index값들이 아닌 val 값인 점이다
	 * 즉 lo,hi의 mid 값을 구해서 이 값보다 작은 것의 수가 k보다 적으면 lo=mid+1이고 크다면 hi = mid-1을 하는 방식 
	 */ 
	 /* 	public class Solution {
		    public int kthSmallest(int[][] matrix, int k) {
		        int n = matrix.length;
		        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
		        while (lo <= hi) {
		            int mid = lo + (hi - lo) / 2;
		            int count = getLessEqual(matrix, mid);
		            if (count < k) lo = mid + 1;
		            else hi = mid - 1;
		        }
		        return lo;
		    }
		    
		    private int getLessEqual(int[][] matrix, int val) {
		        int res = 0;
		        int n = matrix.length, i = n - 1, j = 0;
		        while (i >= 0 && j < n) {
		            if (matrix[i][j] > val) i--;
		            else {
		                res += i + 1;
		                j++;
		            }
		        }
		        return res;
		    }
		}
	 */

	public static void main(String[] args) {
		int [][] matrix = {
				{1,5,9},
				{10,11,13},
				{12,13,15}
		};
		System.out.println(kthSmallest(matrix, 8));
	}

    public static int kthSmallest(int[][] matrix, int k) {
        int [] merge = matrix[0];
        
        for(int n=1; n<matrix.length; n++) {
        	int [] temp = new int [merge.length+matrix[n].length];
        	int i=0, j=0, m=0;
        	while(i < merge.length && j < matrix[n].length) {
        		if(merge[i] < matrix[n][j]) {
        			temp[m++] = merge[i];
        			i++;
        		}
        		else if(merge[i] > matrix[n][j]) {
        			temp[m++] = matrix[n][j];
        			j++;
        		}
        		else {
        			temp[m++] = merge[i];
        			temp[m++] = matrix[n][j];
        			i++;
        			j++;
        		}
        	}
        	
        	while(i != merge.length)
    			temp[m++] = merge[i++];
    			
    		while(j != matrix[n].length)
    			temp[m++] = matrix[n][j++];
    		merge = temp;
        }
        
        return merge[k-1];
    }
}
