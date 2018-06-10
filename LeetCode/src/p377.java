import java.util.Arrays;

/*
 * Problem #377
 * 
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * Example : 
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
	(1, 1, 1, 1)
	(1, 1, 2)
	(1, 2, 1)
	(1, 3)
	(2, 1, 1)
	(2, 2)
	(3, 1)
	
	Output : 7
 * 
 * 42%
 */

public class p377 {
	
	/*
	 * 접근방법
	 * 
	 * 첫번째 시도 : recursive 하게 target-- 하면서 target=0이 되면 result값을 늘려주는 방식
	 * 			모든 경우를 탐색하면서 하는 것이기에 Time limit 뜸
	 * 두번째 시도 : Dynamic Prograaming 이용
	 * 			dp[i]를 target=i 일때의 가능한 모든 combinations이라 정의하고
	 * 			점화식을 dp[i] += dp[i-nums[j]] 로 세움
	 * 			여기서 초기값 dp[0]을 0이라 두었더니 잘못된 값이 나오고 1이라 두니 문제가 제대로 풀림
	 */
	
	public static int combinationSum4(int[] nums, int target) {
        if(nums.length == 0 || target == 0) return 0;
        
        int [] dp = new int [target+1];
        
        dp[0] = 1;
        
        for(int i=1; i<=target; i++){
        	for(int j=0; j<nums.length; j++){
        		if(i-nums[j] >= 0) {
        			dp[i] += dp[i-nums[j]];
        		}
        	}
        }
        
        return dp[target];
    }

	public static void main(String[] args) {
		int [] arr = {1,2,3};
		System.out.println(combinationSum4(arr,4));
	}

}
