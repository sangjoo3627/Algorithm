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
	 * 접근방법
	 * O(logN)으로 만족하려면 binary search로 해결해야한다
	 * 일반적인 binary search 형태로 탐색하면서 특정한 조건을 만족해야한다
	 * 만약 mid가 홀수이면 양옆의 데이터 값을 비교해 
	 * 왼쪽 데이터와 값이 같다면 오른쪽에 result가 존재하고 오른쪽 데이터와 같다면 왼쪽에 result가 존재함
	 * 반대로 mid가 짝수이면 위와 정반대이다
	 * 이런 방식으로 가다가 start == end 이거나 nums[mid]가 양옆의 데이터와 다 다르다면
	 * 그 해당 값이 찾으려는 result 값이다.
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
