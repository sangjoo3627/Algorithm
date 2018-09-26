import java.util.*;

/*
 * Problem #11 Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Example:

	Input: [1,8,6,2,5,4,8,3,7]
	Output: 49
 * 
 * 38%
 */

public class p11 {

	/*
	 * 접근방법
	 * brute force 로하면 O(n^2)이 나와서 memory limit exceeded가 나온다
	 * O(n^2) 이내로 수행할 수 있는 방법을 찾아야하는데 O(n)으로 할 수 있는 방법을 찾았다
	 * 배열의 양쪽 끝을 left, right로 두고 넓이를 구한다
	 * 이제 left, right 중 어느 쪽을 움직이느냐가 중요한데, 여기서 생각할 것은
	 * 어쨋든 더 큰쪽을 버리면 현재까지 구한 maxArea보다 더 큰값이 나올수 없다는 점이다 (구하려는 사각형의 높이가 작은쪽보다 작거나 같기 때문)
	 * 즉, 작은쪽을 버리고 다음 칸으로 옮긴다
	 * left면 left++, right면 right--
	 * 이런식으로 정가운데까지 도착한 후 update된 마지막 maxArea값이 우리가 구하고자하는 정답
	 */
	
	public static void main(String[] args) {
		int [] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}
	
	public static int maxArea(int[] height) {
		int result = 0;
		int left = 0;
		int right = height.length-1;
		
        while(left < right) {
        	result = Math.max(result, (right-left)*Math.min(height[left], height[right]));
        	
        	if(height[left] < height[right])
        		left++;
        	else right--;
        }
        
        return result;
    }
}
