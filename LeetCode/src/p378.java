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
	 * ���� ���ٹ��:
	 * merge sort���� merge �κ��� �̿��Ѵ�
	 * ���� row���� �ϳ��� merge�ϸ鼭 �ϳ��� �迭 merge[]�� ������, merge[k-1]�� ����Ѵ�
	 * �ð����⵵ : O(n^2)
	 * 
	 * Discuss�� �����
	 * 
	 * 1. Heap�� �̿��Ѵ�
	 * PriorityQueue�� ����ؼ� ù row�� ������ ��� pq�� ����ְ� min���� �����鼭 �̰��� ���� �÷����� pq�� �ִ¹��
	 * �ϳ� ȹ������ ����̶� ���������� �ɸ��� �ð��� �������� ���� ���� �ʾ���
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
	
	 /* 2. Binary Search ��� O(nlog(max-min))
	 * 2�����迭�� binary search�̴�, matrix[0][0]�� matrix[n-1][n-1] ���� �������� Ž���ϴµ�
	 * ���⼭ ���� �����ߴ� �Ͱ� �ٸ�����
	 * �� ������ index������ �ƴ� val ���� ���̴�
	 * �� lo,hi�� mid ���� ���ؼ� �� ������ ���� ���� ���� k���� ������ lo=mid+1�̰� ũ�ٸ� hi = mid-1�� �ϴ� ��� 
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
