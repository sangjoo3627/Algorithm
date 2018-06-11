import java.util.*;

/*
 * Problem #128 (Hard)
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1,2,3,4], Therefore its length is 4.
 * 
 * 38%
 */

public class p128 {
	
	/*
	 * 접근방법
	 *  첫번째 : 	nums 배열에서 Max, Min 값을 구해 총 배열 크기를 Max+|Min|+1로 두고 boolean 배열을 하나 만든다
	 * 			nums element가 존재하면 boolean 배열의 index에 true로 설정
	 * 			그 후 boolean 배열을 iterate하면서 연속되게 true인 것을 찾고 동시에 longest인것을 찾는다
	 * 			-> input이 2^31-1 가 들어올시 이만큼 크기의 배열을 만드는것이 불가능 -> 실패
	 * 
	 * 두번째 : 	set을 이용해 연산을 줄인다는 컨셉
	 * 			nums의 elements들을 set에 저장 후 x-1가 set에 존재하지 않는 x를 찾는다
	 * 			즉 찾으려는 subset의 첫번째 element를 찾는것
	 * 			x를 찾았으면 y값을 x+1로 두고 증가하는 값들을 set에서 찾아낸다 -> 이 모든 연산이 O(1)이기에 가능
	 * 			y값을 찾으면서 가장 큰 longest 값을 update 해주고 마지막 longest를 반환
	 * 
	 * Time complexity : Worst case일시, O(n)+O(n-1)로 결국 O(n)을 만족함
	 */
	
    public static int longestConsecutive(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	for(int n: nums) set.add(n);
    	int longest=0;
    	int y=0;
    	
    	for(int x : nums){
    		if(!set.contains(x-1)) {
    			y=x+1;
    			while(set.contains(y))
    				y+=1;
    			longest = Math.max(longest, y-x);
    		}
    	}
    	return longest;
    }
    
	public static void main(String[] args) {
		int [] arr = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(arr));
	}

}