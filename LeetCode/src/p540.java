import java.util.*;

/*
 * Problem #540 Single Element in a Sorted Array
 * 
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. 
 * Find this single element that appears only once.
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * Example 1:
	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2
 * 
 * 56%	
 */

public class p540 {
	/*
	 * ���ٹ��
	 * O(logN)���� �����Ϸ��� binary search�� �ذ��ؾ��Ѵ�
	 * �Ϲ����� binary search ���·� Ž���ϸ鼭 Ư���� ������ �����ؾ��Ѵ�
	 * ���� mid�� Ȧ���̸� �翷�� ������ ���� ���� 
	 * ���� �����Ϳ� ���� ���ٸ� �����ʿ� result�� �����ϰ� ������ �����Ϳ� ���ٸ� ���ʿ� result�� ������
	 * �ݴ�� mid�� ¦���̸� ���� ���ݴ��̴�
	 * �̷� ������� ���ٰ� start == end �̰ų� nums[mid]�� �翷�� �����Ϳ� �� �ٸ��ٸ�
	 * �� �ش� ���� ã������ result ���̴�.
	 */

	public static void main(String[] args) {
		int []arr = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(arr));
	}
	
	public static int singleNonDuplicate(int[] nums) {
		int start=0, end=nums.length-1;
		int mid = (start+end) / 2;
		int result=nums[start];
		
		boolean even;
		
		while(start <= end){
			if(start == end) {
				result = nums[start];
				break;
			}
			
			mid = (start+end) / 2;
			if(mid%2 == 0) even = true;
			else even = false;
			
			if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
				result = nums[mid];
				break;
			}
			else if(nums[mid] != nums[mid-1]){
				if(even) start=mid+1;
				else end=mid-1;
			}
			else{
				if(even) end=mid-1;
				else start=mid+1;
			}
		}
		
		return result;
	}
}
