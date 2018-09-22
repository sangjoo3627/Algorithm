import java.util.*;

/*
 * Problem #228 Summary Ranges
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * Example 1:
	
	Input:  [0,1,2,4,5,7]
	Output: ["0->2","4->5","7"]
	Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 31%
 */

public class p228 {
	
	/*
	 * 접근방법
	 * 리스트 내의 element를 탐색하면서 연속인지 아닌지 판단하는 플래그 값을 하나 두고
	 * 연속적이지 않는 순간 끊고 리스트에 추가하는 방식
	 */

	public static void main(String[] args) {
		int [] arr = {0,2,3,4,6,8,9};
		System.out.println(summaryRanges(arr).toString());
	}
	
	public static List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

		if(nums.length == 0) return result;
		if(nums.length == 1) {
			result.add(String.valueOf(nums[0]));
			return result;
		}
        
		// 연속된 숫자인지 판단하는 flag
		boolean contig = false;
		String e = "";
		
        for(int i=0; i<nums.length; i++) {
        	// 연속된 숫자가 아니였다면 첫 시작 element
        	if(!contig) e = String.valueOf(nums[i]);
        	
        	// 그 다음 숫자와의 차이가 1이라면 contig flag를 설정하고 다음 element로 넘어감
        	if(i != nums.length-1 && nums[i+1] - nums[i] == 1) {
        		contig = true;
        		continue;
        	}
        	// 연속된 숫자가 아니라면 끊고 리스트에 추가, 그리고 string e를 초기화
        	else {
        		if(contig) e = e + "->" + String.valueOf(nums[i]);
        		result.add(e);
        		contig = false;
        		e = "";
        	}
        }
        
        return result;
    }

}
