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
	 * ���ٹ��
	 * ����Ʈ ���� element�� Ž���ϸ鼭 �������� �ƴ��� �Ǵ��ϴ� �÷��� ���� �ϳ� �ΰ�
	 * ���������� �ʴ� ���� ���� ����Ʈ�� �߰��ϴ� ���
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
        
		// ���ӵ� �������� �Ǵ��ϴ� flag
		boolean contig = false;
		String e = "";
		
        for(int i=0; i<nums.length; i++) {
        	// ���ӵ� ���ڰ� �ƴϿ��ٸ� ù ���� element
        	if(!contig) e = String.valueOf(nums[i]);
        	
        	// �� ���� ���ڿ��� ���̰� 1�̶�� contig flag�� �����ϰ� ���� element�� �Ѿ
        	if(i != nums.length-1 && nums[i+1] - nums[i] == 1) {
        		contig = true;
        		continue;
        	}
        	// ���ӵ� ���ڰ� �ƴ϶�� ���� ����Ʈ�� �߰�, �׸��� string e�� �ʱ�ȭ
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
