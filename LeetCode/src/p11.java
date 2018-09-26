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
	 * ���ٹ��
	 * brute force ���ϸ� O(n^2)�� ���ͼ� memory limit exceeded�� ���´�
	 * O(n^2) �̳��� ������ �� �ִ� ����� ã�ƾ��ϴµ� O(n)���� �� �� �ִ� ����� ã�Ҵ�
	 * �迭�� ���� ���� left, right�� �ΰ� ���̸� ���Ѵ�
	 * ���� left, right �� ��� ���� �����̴��İ� �߿��ѵ�, ���⼭ ������ ����
	 * ��¶�� �� ū���� ������ ������� ���� maxArea���� �� ū���� ���ü� ���ٴ� ���̴� (���Ϸ��� �簢���� ���̰� �����ʺ��� �۰ų� ���� ����)
	 * ��, �������� ������ ���� ĭ���� �ű��
	 * left�� left++, right�� right--
	 * �̷������� ��������� ������ �� update�� ������ maxArea���� �츮�� ���ϰ����ϴ� ����
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
