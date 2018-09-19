package BruteForce;
import java.util.*;

/*
 * Problem #1182
 * 
 * N개의 정수로 이루어진 집합이 있을 때, 이 집합의 공집합이 아닌 부분집합 중에서 그 집합의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 
 * 	입력
	첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1≤N≤20, |S|≤1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절대값은 100,000을 넘지 않는다. 같은 수가 여러번 주어질 수도 있다.
	
	출력
	첫째 줄에 합이 S가 되는 부분집합의 개수를 출력한다.
 */

public class p1182 {

	static int cnt, currentSum, N, S;
	static int [] nums = new int [20];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		for(int i=0; i<N; i++)
			nums[i] = sc.nextInt();
		
		dfs(0);
		System.out.println(cnt);
	}
	
	public static void dfs (int current){
		if(current == N) return;
		
		// 현재까지의 합이 S면 결과 +1
		if(currentSum + nums[current] == S) cnt++;
		
		// 이번 원소 포함시키지 않고 시도
		dfs(current+1);
		
		// 이번 원소 포함시키고 시도
		currentSum +=nums[current];
		dfs(current+1);
		
		// 마지막에 다시 이번 원소를 뺌
		currentSum -= nums[current];
	}
	

}
