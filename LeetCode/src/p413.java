import java.util.*;

/*
 * Problem# 413 Arithmetic Slices
 * 
 * A sequence of number is called arithmetic if it consists of at least three elements 
 * and if the difference between any two consecutive elements is the same.
 * 
 * For example, these are arithmetic sequence:

	1, 3, 5, 7, 9
	7, 7, 7, 7
	3, -1, -5, -9
	
 * 	A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

	A slice (P, Q) of array A is called arithmetic if the sequence:
	A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
	
	The function should return the number of arithmetic slices in the array A.
	
	Example:

	A = [1, 2, 3, 4]
	
	return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 
 * 54%
 */

public class p413 {
	/*
	 * 접근방법 : dp
	 * dp[i]는 A[i]를 끝으로 하는 모든 arithmetic slices들의 갯수
	 * 즉 A[i]-A[i-1] 과 A[i-1]-A[i-2]의 값이 같다면 dp[i]는 dp[i-1]을 포함하고 A[i]가 추가된 slices도 arithmetic slice라는 의미이므로
	 * dp[i] = dp[i-1] + 1
	 * 
	 */

	public static void main(String[] args) {
		int [] A = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(A));
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		/*
        int curr = 0;
        int sum = 0;
        
        for(int i = 2; i<A.length; i++){
        	if(A[i]-A[i-1] == A[i-1]-A[i-2]) {
        		curr++;
        		sum += curr;
        	}
        	else
        		curr = 0;
        }
        
        return sum;
        */
		
		int maxSize = A.length;
		if(maxSize < 3) return 0;
		
		int [] dp = new int [maxSize];	// dp[i] means the number of arithmetic slices ending with A[i]
		
		if(A[2]-A[1] == A[1]-A[0]) dp[2] = 1;
		int result = dp[2];
		
		for(int i=3; i<maxSize; i++){
			if(A[i]-A[i-1] == A[i-1]- A[i-2]) dp[i] = dp[i-1] + 1;
			result += dp[i];
		}
		
		return result;
    }

}
