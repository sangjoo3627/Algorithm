package BackTracking;
import java.util.*;

/*
 * Problem #1759 ��ȣ�����
 * 
 * �ٷ� ���� �ֹ��� ������ �� ���踦 �ָӴϿ� ���� ä �����ϰ� ����� �� ������ Ȳ���� ��Ȳ�� ������ ��������, 702ȣ�� ���ο� ���� �ý����� ��ġ�ϱ�� �Ͽ���. �� ���� �ý����� ���谡 �ƴ� ��ȣ�� �����ϰ� �Ǿ� �ִ� �ý����̴�.
 * ��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ������ �ּ� �� ���� �������� �����Ǿ� �ִٰ� �˷��� �ִ�. 
 * ���� ���ĵ� ���ڿ��� ��ȣ�ϴ� �������� �������� �̷�� ���� ��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭�Ǿ��� ���̶�� �����ȴ�. ��, abc�� ���ɼ��� �ִ� ��ȣ������ bac�� �׷��� �ʴ�.
 * �� ���� �ý��ۿ��� �������� ��ȣ�� ������� ���� ������ ������ C������ �ִٰ� �Ѵ�. �� ���ĺ��� �Լ��� �ν�, ���� ������ �������� �濡 ħ���ϱ� ���� ��ȣ�� ������ ������ �Ѵ�. 
 * C���� ���ڵ��� ��� �־����� ��, ���ɼ� �ִ� ��ȣ���� ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
	�Է�
	ù° �ٿ� �� ���� L, C�� �־�����. (3 �� L �� C �� 15) ���� �ٿ��� C���� ���ڵ��� �������� ���еǾ� �־�����. �־����� ���ڵ��� ���ĺ� �ҹ����̸�, �ߺ��Ǵ� ���� ����.
	
	���
	�� �ٿ� �ϳ���, ���������� ���ɼ� �ִ� ��ȣ�� ��� ����Ѵ�.
 */
public class p1759 {
	
	static int L, C;
	static String [] list;
	static ArrayList <String> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		list = new String [C];
		for(int i=0; i<C; i++)
			list[i] = sc.next();
		
		Arrays.sort(list);
		backtracking(0,0,"",0,0);
	}

	// ��Ʈ��ŷ���� �ذ�, 
	// offset(���ݱ����߰��� letter�� ����), n(list�� �ε���), str(��������� �߰��� string), m(���� ����), j(���� ����)
	public static void backtracking (int offset, int n, String str, int m, int j){
		// ���̰� L���� �ٴٸ��� ����, ���� ������ ���������� ���
		if(offset == L && m>=1 && j>=2) {
			System.out.println(str);
			return;
		}
		if(n >= C) return;
		
		String s = list[n];
		int tmp = s.charAt(0)-'a';
		int mm=0;
		int jj=0;
		
		// ���� �Ǻ�
		if(tmp == 0 || tmp == 4 || tmp == 8 || tmp == 14 || tmp == 20) mm++;
		else jj++;
		
		// �־��� ���
		backtracking(offset+1, n+1, str+s, m+mm, j+jj);
		
		// �� �־��� ���
		backtracking(offset, n+1, str, m, j);
	}
}
