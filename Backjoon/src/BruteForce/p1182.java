package BruteForce;
import java.util.*;

/*
 * Problem #1182
 * 
 * N���� ������ �̷���� ������ ���� ��, �� ������ �������� �ƴ� �κ����� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * 	�Է�
	ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1��N��20, |S|��1,000,000) ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ���밪�� 100,000�� ���� �ʴ´�. ���� ���� ������ �־��� ���� �ִ�.
	
	���
	ù° �ٿ� ���� S�� �Ǵ� �κ������� ������ ����Ѵ�.
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
		
		// ��������� ���� S�� ��� +1
		if(currentSum + nums[current] == S) cnt++;
		
		// �̹� ���� ���Խ�Ű�� �ʰ� �õ�
		dfs(current+1);
		
		// �̹� ���� ���Խ�Ű�� �õ�
		currentSum +=nums[current];
		dfs(current+1);
		
		// �������� �ٽ� �̹� ���Ҹ� ��
		currentSum -= nums[current];
	}
	

}
