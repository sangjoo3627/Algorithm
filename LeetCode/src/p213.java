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
	 * ���ٹ��:
	 * 2���� DP�� �ذ�
	 * ������ ������ element��� ��ġ�� �����鼭 �ִ밪�� ã�� ����� dp ������ ���������
	 * element���� circular�ϰ� �����ٴ� ���� ����
	 * �� ������ ���ҿ� ù��° ���Ұ� �����Ѵٴ� ���� �����ϰ� ��ȭ���� �ۼ�
	 * ù��° ���Ұ� ���Ե� max���� ���Ե��� ���� max���� �ΰ��� ���� �����Ͽ� ����
	 * dp[i][0] : 	ù��° element�� ���� ���ϸ鼭 i��° element������ house �� ���� �� �ִ� maximum amount of money
	 * 				Max(dp[i-1][0], dp[i-2][0] + nums[i-1])
	 * dp[i][1] : 	ù��° element�� �����ϰ� i��° element������ maximum money
	 * 				Max(dp[i-1][1], dp[i-2][1] + nums[i-1])
	 * 
	 * �׸��� ������ ���ҿ� ���������� ��츦 ó��
	 * ������ ������ ��쿡�� ù��° ���Ұ� ���Ե� ���� ������ ������ ���� �߰��Ҽ� ����
	 * �� dp[i][1] = dp[i-1][1]
	 * 
	 * Time complexity : O(n), Space complexity : O(n)
	 */

	public static int rob(int[] nums) {
        int max=0;
        
        // ������ ������ 0�̸� �ٷ� max�� 0 ��ȯ
        if(nums.length == 0) return 0;
        
        // ù��° ���Ҹ� ����/�������� ��츦 ������ dp[][2] ����
        int [][] dp = new int [nums.length+1][2];
        // dp�迭 �ʱⰪ ����
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        max = dp[1][1];
        
        for(int i=2; i<nums.length+1; i++){
        	// ������ ���ҿ� �ٴٶ��� ��
        	if(i == nums.length){
        		// �� ���Ұ� 3���ۿ� �ȵȴٸ� 2��° ���� ���ҿ� circular�� ����� ���Ұ� �����Ƿ� ������� ����
        		if(i-2 == 1) break;
        		// circular�� ����Ͽ� ù��° ���Ұ� ���Ե� dp[][1]���� ������ ���Ұ��� �߰����� ����
        		else{
        			dp[i][0] = dp[i-2][0] + nums[i-1];
        			dp[i][1] = dp[i-1][1];
        		}
        	}
        	// ��ȭ��
        	else {
        		dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + nums[i-1]);
        		dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + nums[i-1]);
        	}
        	// dp���� ���Ҷ����� max���� update
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
