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
	 * ���ٹ��
	 *  ù��° : 	nums �迭���� Max, Min ���� ���� �� �迭 ũ�⸦ Max+|Min|+1�� �ΰ� boolean �迭�� �ϳ� �����
	 * 			nums element�� �����ϸ� boolean �迭�� index�� true�� ����
	 * 			�� �� boolean �迭�� iterate�ϸ鼭 ���ӵǰ� true�� ���� ã�� ���ÿ� longest�ΰ��� ã�´�
	 * 			-> input�� 2^31-1 �� ���ý� �̸�ŭ ũ���� �迭�� ����°��� �Ұ��� -> ����
	 * 
	 * �ι�° : 	set�� �̿��� ������ ���δٴ� ����
	 * 			nums�� elements���� set�� ���� �� x-1�� set�� �������� �ʴ� x�� ã�´�
	 * 			�� ã������ subset�� ù��° element�� ã�°�
	 * 			x�� ã������ y���� x+1�� �ΰ� �����ϴ� ������ set���� ã�Ƴ��� -> �� ��� ������ O(1)�̱⿡ ����
	 * 			y���� ã���鼭 ���� ū longest ���� update ���ְ� ������ longest�� ��ȯ
	 * 
	 * Time complexity : Worst case�Ͻ�, O(n)+O(n-1)�� �ᱹ O(n)�� ������
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