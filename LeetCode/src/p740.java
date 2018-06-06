import java.util.*;

/*
 * Problem #740
 * 
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * 
 * Input : nums = [3,4,2]
 * Output : 6
 * Explanation:	Delete 4 to earn 4 points, consequently 3 is also deleted.
 * 				Then, delete 2 to earn 2 points. 6 total points are earned.
 * 
 * 43%
 */

public class p740 {

	/*
	 * 접근방법:
	 * 같은 element인 것들의 수를 각각 구하고 인접한 수가 아닌 것들의 합들을 구하는 dp 문제 응용
	 * 즉 {2,2,3,3,3,5,5} 일때 2는 2개 이므로 a[2]=4, 3은 a[3]=9, 5는 a[5]=10
	 * 이런식으로 중복된 값들을 더해 Set을 만들어준다 (a 배열)
	 * 
	 * 그 후 dp[i]는 i라는 element까지 max point로 memoization
	 * dp[i-2]+a[i]와 dp[i-1] 중 큰 값을 저장하는 방식
	 * 
	 * Time complexity : O(n*m) (n은 array의 길이, m은 array에서 가장 큰 max number)
	 */
	
	public static int deleteAndEarn(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int max_num = nums[nums.length-1];
        
        // 중복된 값들을 합치는 과정 -> a[i]는 i라는 수들을 합친 값
        int [] a = new int [max_num+1];
        for(int i=1; i<=max_num; i++){
        	int num = 0;
        	for(int j=0; j<nums.length; j++) 
        		if(nums[j] == i) num++;
        	a[i] = num*i;
        }
        
        // i라는 수까지의 max point 값을 저장
        int [] dp = new int [max_num+1];
        // 초기값 설정
        dp[0] = 0;
        dp[1] = a[1];
        max = dp[1];
        for(int i=2; i<=max_num; i++){
        	// dp 점화식
        	dp[i] = Math.max(dp[i-2]+a[i], dp[i-1]);
        	// max 값 update
        	if(max < dp[i]) max= dp[i];
        }
        
        return max;
    }	
	
	public static void main(String[] args) {
		int [] nums = {1};
		System.out.println(deleteAndEarn(nums));
	}

}
