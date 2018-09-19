package BackTracking;
import java.util.*;

/*
 * Problem #1987 ���ĺ�
 * 
 * ���� Rĭ, ���� Cĭ���� �� ǥ ����� ���尡 �ִ�. ������ �� ĭ���� �빮�� ���ĺ��� �ϳ��� ���� �ְ�, ���� ��� ĭ (1�� 1��) ���� ���� ���� �ִ�.
 * ���� �����¿�� ������ �� ĭ ���� �� ĭ���� �̵��� �� �ִµ�, ���� �̵��� ĭ�� ���� �ִ� ���ĺ��� ���ݱ��� ������ ��� ĭ�� ���� �ִ� ���ĺ����� �޶�� �Ѵ�. ��, ���� ���ĺ��� ���� ĭ�� �� �� ���� �� ����
 * ���� ��ܿ��� �����ؼ�, ���� �ִ��� �� ĭ�� ���� �� �ִ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ������ ĭ�� ���� ����� ĭ�� ���Եȴ�.
 * 
	�Է�
	ù° �ٿ� R�� C�� ��ĭ�� ���̿� �ΰ� �־�����. (1<=R,C<=20) ��° �ٺ��� R���� �ٿ� ���ļ� ���忡 ���� �ִ� C���� �빮�� ���ĺ����� ��ĭ ���� �־�����.
	
	���
	ù° �ٿ� ���� ���� �� �ִ� �ִ��� ĭ ���� ����Ѵ�.
 */

public class p1987 {

	/*
	 * ���ٹ��
	 * �ؽ������� ������ ���ĺ����� �����ؼ� �ߺ����� �ʴ��� �Ǵ��Ѵ�
	 * ���� �����̴� ��ġ�� �� ���� ����ų� �ߺ��� ���ĺ��̶�� �ٽ� ���ƿ��� ��Ʈ��ŷ ����� ����
	 * ���⼭ �߿��� ���� �� �������� �� �������� ��츦 �ڵ� �߰�������Ѵٴ°�!! (�̰� ������ ������...)
	 */
	
	static int R,C,result;
	static String [][] map;
	static Set<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		set = new HashSet<>();
		
		map = new String[R][C];
		for(int i=0; i<R; i++){
			String s = sc.next();
			for(int j=0; j<C; j++){
				char temp = s.charAt(j);
				map[i][j] = Character.toString(temp);
			}
		}
		
		dfs(0,0,1);
		System.out.println(result);
	}

	public static void dfs (int r, int c, int nums){
		if(r>=R || r<0 || c>=C || c<0) return;	// �ʻ� �������
		if(set.contains(map[r][c])) return;		// �ߺ��� ���ĺ��϶�
		else {
			set.add(map[r][c]);		
			result = Math.max(result, nums);	// �������ٸ� �Ÿ��� +1�ϰ� �ִ�Ÿ��� update
			nums++;
		}
		
		// �����ϼ� �������� ������
		dfs(r+1, c, nums);
		dfs(r, c+1, nums);
		dfs(r-1, c, nums);
		dfs(r, c-1, nums);
		
		// �� �������� ���
		set.remove(map[r][c]);
		nums--;
	}
}
