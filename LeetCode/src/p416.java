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
	 * DFS로 백트랙킹을 써서 Brute force로 하면 Time limit이 나온다
	 * dp를 이용해야하는데
	 * dp[n+1][mid+1]로 초기화하고, (mid는 구해야하는 값, subset의 합이 mid가 되는지 판단)
	 * dp[i][j]는 0~i번째까지의 element의 subset에서 j를 만들수 있는 sum을 pick할수 있는지, (true/false)
	 * 
	 * dp[i][0]은 모두 true, dp[0][j]는 모두 false
	 * 점화식 : dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]
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
        		// i번째 element를 pick 하지 않았을 경우,
        		dp[i][j] = dp[i-1][j];
        		
        		// i번째 element가 구하려는 mid 보다 작은 경우, pick할 가능성이 있다고 본다
        		// 여기서 i-1인 이유는 dp[i][]에서의 i와 nums[i]에서의 i가 한칸씩 밀려났기 때문
        		if(j >= nums[i-1]) {
        			// mid에서 nums[i-1]을 뺀 값이 그 전까지의 subset에서 만들어질 수 있다면, nums[i-1]을 포함한 sum도 pick할수 있다는뜻 -> true
        			dp[i][j] = ( dp[i][j] || dp[i-1][j-nums[i-1]] );
        		}
        	}
        }
        
        return dp[n][mid];
    }
}
