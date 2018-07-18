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
	 * 접근방법
	 * 조금 개선한 전탐색으로하면 O(n^2)이지만 Accepted 됬음, mod를 이용해서 next greater를 찾으면 바로 break하는 방식 -> 사실상 O(n^2)에 타이트하지는 않음
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
