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
	 * ���ٹ��:
	 * ���� element�� �͵��� ���� ���� ���ϰ� ������ ���� �ƴ� �͵��� �յ��� ���ϴ� dp ���� ����
	 * �� {2,2,3,3,3,5,5} �϶� 2�� 2�� �̹Ƿ� a[2]=4, 3�� a[3]=9, 5�� a[5]=10
	 * �̷������� �ߺ��� ������ ���� Set�� ������ش� (a �迭)
	 * 
	 * �� �� dp[i]�� i��� element���� max point�� memoization
	 * dp[i-2]+a[i]�� dp[i-1] �� ū ���� �����ϴ� ���
	 * 
	 * Time complexity : O(n*m) (n�� array�� ����, m�� array���� ���� ū max number)
	 */
	
	public static int deleteAndEarn(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int max_num = nums[nums.length-1];
        
        // �ߺ��� ������ ��ġ�� ���� -> a[i]�� i��� ������ ��ģ ��
        int [] a = new int [max_num+1];
        for(int i=1; i<=max_num; i++){
        	int num = 0;
        	for(int j=0; j<nums.length; j++) 
        		if(nums[j] == i) num++;
        	a[i] = num*i;
        }
        
        // i��� �������� max point ���� ����
        int [] dp = new int [max_num+1];
        // �ʱⰪ ����
        dp[0] = 0;
        dp[1] = a[1];
        max = dp[1];
        for(int i=2; i<=max_num; i++){
        	// dp ��ȭ��
        	dp[i] = Math.max(dp[i-2]+a[i], dp[i-1]);
        	// max �� update
        	if(max < dp[i]) max= dp[i];
        }
        
        return max;
    }	
	
	public static void main(String[] args) {
		int [] nums = {1};
		System.out.println(deleteAndEarn(nums));
	}

}
