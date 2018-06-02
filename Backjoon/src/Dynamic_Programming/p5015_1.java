/*
 * ls  (dp�̿� ���ϰ� ��Ž������ �Ѱ� -> �ð��ʰ�����;;)
 */
package Dynamic_Programming;
import java.util.*;
public class p5015_1 {

	public static boolean match(String w, String s){
		
		// w[pos]�� s[pos]�� 1��1 ��Ī
		int pos=0;
		while(pos < w.length() && pos < s.length() &&
				w.charAt(pos) == s.charAt(pos))
			pos++;
		
		// ���̻� ��Ī�Ǵ°� ������ �� while�� ������������
		// ���� ���� �����Ͽ� ���� ��� : ���ڿ��� ������� ����
		if(pos == w.length())
			return pos == s.length();
		
		// *�� ������ ���� ��� : *�� �� ���ڸ� ���ؾ��ϴ��� �𸣹Ƿ� ���ȣ��� Ȯ��
		if(w.charAt(pos) == '*'){
			for (int skip=0; pos+skip <= s.length(); skip++){
				if(match(w.substring(pos+1),s.substring(pos+skip)))
					return true;
			}
		}
		
		// �׿ܿ� ����
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String pattern = sc.nextLine();
		int n = Integer.parseInt(sc.nextLine());
		ArrayList <String> ans = new ArrayList();
		
		for(int i=0; i<n; i++){
			
			String str = sc.nextLine();
			if(match(pattern, str))
				ans.add(str);
		}
		
		for(String s : ans)
			System.out.println(s);
		
	}

}
