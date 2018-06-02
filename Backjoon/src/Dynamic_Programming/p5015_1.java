/*
 * ls  (dp이용 안하고 전탐색으로 한것 -> 시간초과나옴;;)
 */
package Dynamic_Programming;
import java.util.*;
public class p5015_1 {

	public static boolean match(String w, String s){
		
		// w[pos]와 s[pos]을 1대1 매칭
		int pos=0;
		while(pos < w.length() && pos < s.length() &&
				w.charAt(pos) == s.charAt(pos))
			pos++;
		
		// 더이상 매칭되는게 없으면 왜 while을 빠져나왔을지
		// 패턴 끝에 도달하여 끝난 경우 : 문자열도 끝났어야 성공
		if(pos == w.length())
			return pos == s.length();
		
		// *을 만나서 끝난 경우 : *에 몇 글자를 더해야하는지 모르므로 재귀호출로 확인
		if(w.charAt(pos) == '*'){
			for (int skip=0; pos+skip <= s.length(); skip++){
				if(match(w.substring(pos+1),s.substring(pos+skip)))
					return true;
			}
		}
		
		// 그외엔 실패
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
