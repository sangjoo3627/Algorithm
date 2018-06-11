/*
 * Problem #78
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
  	[3],
  	[1],
  	[2],
  	[1,2,3],
  	[1,3],
  	[2,3],
  	[1,2],
  	[]
 *	]
 * 
 * 43%
 */

import java.util.*;
public class p78 {

	/*
	 * 접근방법:
	 * backtracking 방식으로 tempList를 생성해 recursive하게 구현
	 */
	
	public static List<List<Integer>> subsets(int[] nums) {
        List <List<Integer>> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(subset, new ArrayList<>(), nums, 0);
        return subset;
    }
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i =start; i<nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {1,2,3};
		System.out.println(subsets(arr));
	}

}
