/*
 * Problem #718
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 */

public class p718 {

	/*
	 * 접근방법:
	 * array A와 B에서 element가 같은 index를 찾아 start로 설정하고
	 * start index를 증가시키며 계속 같은 element들이 존재할때 subarray가 있다고 판단하고 max 값을 업데이트한다
	 * 모든 경우의 수를 이중포문으로 돌린 후 max값을 출력
	 * 
	 * Time complexity : O(n*m*l)  (n:length of A, m:length of B, l:min length of both)
	 */
	
	public static int findLength(int[] A, int[] B) {
		int max = 0;
		int n = A.length;
		int m = B.length;
		
		Root_for:
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(A[i] == B[j]){
					int start_a = i;
					int start_b = j;
					int max_tmp = 0;
					while(start_a<n && start_b<m && A[start_a] == B[start_b]){
						max_tmp++;
						start_a++;
						start_b++;
					}
					if(max < max_tmp) max = max_tmp;
					if(max == n || max == m) break Root_for;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] A = { 0,0,0,0,0,0,1,0,0,0 };
		int[] B = { 0,0,0,0,0,0,0,1,0,0 };
		System.out.println(findLength(A, B));
	}

}
