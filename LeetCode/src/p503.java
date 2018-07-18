import java.util.*;

/*
 * Problem #503 Next Greater Element ll
 * 
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number
 * If it doesn't exist, output -1 for this number.
 * 
 * Example
 * 	Input: [1,2,1]
	Output: [2,-1,2]
 * 
 * 48%
 */

public class p503 {

	/*
	 * ���ٹ��
	 * ���� ������ ��Ž�������ϸ� O(n^2)������ Accepted ����, mod�� �̿��ؼ� next greater�� ã���� �ٷ� break�ϴ� ��� -> ��ǻ� O(n^2)�� Ÿ��Ʈ������ ����
	 */
	
	public static int[] nextGreaterElements(int[] nums) {
		int [] result = new int [nums.length];
		
		if(nums.length == 0) return nums;
		if(nums.length == 1){
			result[0] = -1;
			return result;
		}
        
		for(int i=0; i<nums.length; i++){
			int cur = nums[i];
			int j = (i+1)%nums.length;
			boolean flag = false;
			while(j != i){
				
				if(cur < nums[j]) {
					result[i] = nums[j];
					flag = true;
					break;
				}
				if(!flag) result[i] = -1;
				j = (j+1)%nums.length;
			}
			
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int [] a = {1};
		System.out.println(Arrays.toString(nextGreaterElements(a)));
	}

}
