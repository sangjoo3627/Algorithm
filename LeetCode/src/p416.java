import java.util.*;

/*
 *  Problem #416 Partition Equal Subset Sum
 *  
 *  Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets 
 *  such that the sum of elements in both subsets is equal.
 *  
 *  Note:
	Each of the array element will not exceed 100.
	The array size will not exceed 200.
	
	Example 1:
		Input: [1, 5, 11, 5]
		Output: true
		Explanation: The array can be partitioned as [1, 5, 5] and [11].
		
	Example 2:
		Input: [1, 2, 3, 5]
		Output: false
		Explanation: The array cannot be partitioned into equal sum subsets.
 *  
 *  38%
 */

public class p416 {
	
	/*
	 * DFS�� ��Ʈ��ŷ�� �Ἥ Brute force�� �ϸ� Time limit�� ���´�
	 * dp�� �̿��ؾ��ϴµ�
	 * dp[n+1][mid+1]�� �ʱ�ȭ�ϰ�, (mid�� ���ؾ��ϴ� ��, subset�� ���� mid�� �Ǵ��� �Ǵ�)
	 * dp[i][j]�� 0~i��°������ element�� subset���� j�� ����� �ִ� sum�� pick�Ҽ� �ִ���, (true/false)
	 * 
	 * dp[i][0]�� ��� true, dp[0][j]�� ��� false
	 * ��ȭ�� : dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]
	 */
	
	public static void main(String[] args) {
		int [] arr = {2,2,3,5};
		System.out.println(canPartition(arr));
	}

	public static boolean canPartition(int[] nums) {
        int sum = 0;
        int mid = 0;
        
        for(int n : nums)
        	sum += n;
        
        if(sum%2 != 0) return false;
        
        mid = sum/2;
        int n = nums.length;
        
        // dp[n+1][mid+1]
        boolean [][] dp = new boolean [n+1][mid+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        
        for(int i=1; i<=n; i++) dp[i][0] = true;
        for(int i=1; i<=mid; i++) dp[0][i] = false;
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=mid; j++) {
        		// i��° element�� pick ���� �ʾ��� ���,
        		dp[i][j] = dp[i-1][j];
        		
        		// i��° element�� ���Ϸ��� mid ���� ���� ���, pick�� ���ɼ��� �ִٰ� ����
        		// ���⼭ i-1�� ������ dp[i][]������ i�� nums[i]������ i�� ��ĭ�� �з����� ����
        		if(j >= nums[i-1]) {
        			// mid���� nums[i-1]�� �� ���� �� �������� subset���� ������� �� �ִٸ�, nums[i-1]�� ������ sum�� pick�Ҽ� �ִٴ¶� -> true
        			dp[i][j] = ( dp[i][j] || dp[i-1][j-nums[i-1]] );
        		}
        	}
        }
        
        return dp[n][mid];
    }
}
