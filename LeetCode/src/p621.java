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
	 * 접근방법
	 * 직접 스케줄러처럼 짤 필요없이 총 interval 개수만 출력하면 되므로 수학 계산으로 가능
	 * 먼저 각 char마다 task의 수를 구하고 정렬한 후
	 * 가장 task 수가 많은 char를 토대로 최소 있어야할 interval을 구한다 (least 변수)
	 * least = (max-1) * (n+1) + 1
	 * ex) 만약 AAABBCC이고 n=3이라면 AXXXAXXXA 이런식으로 공간을 남기고 마지막만 A 하나 추가하는 방식
	 * 만약 max값이 같은 char가 존재한다면 맨뒤에 추가하면 된다
	 * ex) AAABBBCC, n=3일 경우, ABCXABCXA(B) 이런식으로 
	 * 모든 char의 개수를 체크하여 max값과 같을경우 1씩 값을 증가시킨 후
	 * 마지막 task의 개수와 least의 개수 중 큰 값을 출력한다
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
        int size = nums.length;		// 총 알파벳 개수 (고정값 = 26)
        int max = nums[size-1];		// 가장 task개수가 많은 char 값
       
        int least = (max-1) * (n+1) + 1;	// 가장 최소로 존재해야할 interval 개수
        
        for(int i=size-2; i>=0; i--)
        	if(nums[i] == max) least++;	// max값과 같은 개수의 task인 char가 중복으로 있다면 맨뒤에 하나씩 추가
        
        // task 총 수와 least수와 비교하여 큰 값을 출력
        if(tasks.length > least)
        	return tasks.length;
        else
        	return least;
    }
}
