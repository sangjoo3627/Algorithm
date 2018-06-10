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
	 * ���ٹ��
	 * 
	 * ù��° �õ� : recursive �ϰ� target-- �ϸ鼭 target=0�� �Ǹ� result���� �÷��ִ� ���
	 * 			��� ��츦 Ž���ϸ鼭 �ϴ� ���̱⿡ Time limit ��
	 * �ι�° �õ� : Dynamic Prograaming �̿�
	 * 			dp[i]�� target=i �϶��� ������ ��� combinations�̶� �����ϰ�
	 * 			��ȭ���� dp[i] += dp[i-nums[j]] �� ����
	 * 			���⼭ �ʱⰪ dp[0]�� 0�̶� �ξ����� �߸��� ���� ������ 1�̶� �δ� ������ ����� Ǯ��
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
