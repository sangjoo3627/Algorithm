/*
 * Problem #152 Maximum Product Subarray
 * 
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * Example 1:

	Input: [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
	
	27%
 */

public class p152 {
	public static int maxProduct(int[] nums) {
		int max = nums[0];
		
		int tmax = max;
		int tmin = max;
		
		for(int i=1; i<nums.length; i++){
			if(nums[i] < 0) {
				int tmp = tmax;
				tmax = tmin;
				tmin = tmp;
			}
			tmax = Math.max(nums[i], tmax*nums[i]);
			tmin = Math.min(nums[i], tmin*nums[i]);
			max = Math.max(tmax, max);
		}
		return max;
		
		/* Àü Å½»ö ¹æ¹ý
		if(nums.length == 0) return 0;
		
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        
		int [][] dp = new int [len][len];
		for(int i=0; i<len; i++) {
			dp[i][i] = nums[i];
			if(max < dp[i][i]) max = dp[i][i];
		}
		
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++){
				dp[i][j] = dp[i][j-1]*nums[j];
				if(max < dp[i][j]) max = dp[i][j];
			}
		}
		return max;
		*/
    }
	
	public static void main(String[] args) {
		int [] nums = {2,3,-2,-4};
		System.out.println(maxProduct(nums));
	}

}
