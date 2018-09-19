import java.util.*;

/*
 * Problem #621 Task Scheduler
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, 
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * Example 1:
	Input: tasks = ["A","A","A","B","B","B"], n = 2
	Output: 8
	Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 42%
 */

public class p621 {
	
	/*
	 * ���ٹ��
	 * ���� �����ٷ�ó�� © �ʿ���� �� interval ������ ����ϸ� �ǹǷ� ���� ������� ����
	 * ���� �� char���� task�� ���� ���ϰ� ������ ��
	 * ���� task ���� ���� char�� ���� �ּ� �־���� interval�� ���Ѵ� (least ����)
	 * least = (max-1) * (n+1) + 1
	 * ex) ���� AAABBCC�̰� n=3�̶�� AXXXAXXXA �̷������� ������ ����� �������� A �ϳ� �߰��ϴ� ���
	 * ���� max���� ���� char�� �����Ѵٸ� �ǵڿ� �߰��ϸ� �ȴ�
	 * ex) AAABBBCC, n=3�� ���, ABCXABCXA(B) �̷������� 
	 * ��� char�� ������ üũ�Ͽ� max���� ������� 1�� ���� ������Ų ��
	 * ������ task�� ������ least�� ���� �� ū ���� ����Ѵ�
	 */

	public static void main(String[] args) {
		char [] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		System.out.println(leastInterval(tasks, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
        int [] nums = new int [26];
        
        for(char i : tasks)
        	nums[i-'A']++;
        
        Arrays.sort(nums);
        int size = nums.length;		// �� ���ĺ� ���� (������ = 26)
        int max = nums[size-1];		// ���� task������ ���� char ��
       
        int least = (max-1) * (n+1) + 1;	// ���� �ּҷ� �����ؾ��� interval ����
        
        for(int i=size-2; i>=0; i--)
        	if(nums[i] == max) least++;	// max���� ���� ������ task�� char�� �ߺ����� �ִٸ� �ǵڿ� �ϳ��� �߰�
        
        // task �� ���� least���� ���Ͽ� ū ���� ���
        if(tasks.length > least)
        	return tasks.length;
        else
        	return least;
    }
}
