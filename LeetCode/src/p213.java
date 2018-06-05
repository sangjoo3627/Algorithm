/*
 * Problem #213
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
 * All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Input : [2,3,2]
 * Output : 3
 * Explanation : You cannot rob house 1 (money=2) and then rob house 3 (money=2), because they are adjacent houses.
 * 
 * 34%
 */

public class p213 {
	
	/*
	 * 접근방법:
	 * 2차원 DP로 해결
	 * 인접한 양쪽의 element들과 겹치지 않으면서 최대값을 찾는 평범한 dp 문제와 비슷하지만
	 * element들이 circular하게 연결됬다는 점이 관건
	 * 즉 마지막 원소와 첫번째 원소가 인접한다는 것을 인지하고 점화식을 작성
	 * 첫번째 원소가 포함된 max값과 포함되지 않은 max값을 두가지 따로 저장하여 관리
	 * dp[i][0] : 	첫번째 element를 선택 안하면서 i번째 element까지의 house 중 얻을 수 있는 maximum amount of money
	 * 				Max(dp[i-1][0], dp[i-2][0] + nums[i-1])
	 * dp[i][1] : 	첫번째 element를 선택하고 i번째 element까지의 maximum money
	 * 				Max(dp[i-1][1], dp[i-2][1] + nums[i-1])
	 * 
	 * 그리고 마지막 원소에 접근했을때 경우를 처리
	 * 마지막 원소의 경우에는 첫번째 원소가 포함된 값엔 마지막 원소의 값을 추가할수 없다
	 * 즉 dp[i][1] = dp[i-1][1]
	 * 
	 * Time complexity : O(n), Space complexity : O(n)
	 */

	public static int rob(int[] nums) {
        int max=0;
        
        // 원소의 개수가 0이면 바로 max값 0 반환
        if(nums.length == 0) return 0;
        
        // 첫번째 원소를 포함/불포함의 경우를 생각해 dp[][2] 생성
        int [][] dp = new int [nums.length+1][2];
        // dp배열 초기값 설정
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        max = dp[1][1];
        
        for(int i=2; i<nums.length+1; i++){
        	// 마지막 원소에 다다랐을 때
        	if(i == nums.length){
        		// 총 원소가 3개밖에 안된다면 2번째 전의 원소와 circular로 연결된 원소가 같으므로 고려하지 않음
        		if(i-2 == 1) break;
        		// circular를 고려하여 첫번째 원소가 포함된 dp[][1]에는 마지막 원소값을 추가하지 않음
        		else{
        			dp[i][0] = dp[i-2][0] + nums[i-1];
        			dp[i][1] = dp[i-1][1];
        		}
        	}
        	// 점화식
        	else {
        		dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + nums[i-1]);
        		dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + nums[i-1]);
        	}
        	// dp값을 구할때마다 max값을 update
        	if(max < dp[i][0] || max < dp[i][1]) {
        		if(dp[i][0] > dp[i][1])
        			max = dp[i][0];
        		else max = dp[i][1];
        	}
        }
        return max;
    }
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,1,5};
		System.out.println(rob(arr));
	}

}
