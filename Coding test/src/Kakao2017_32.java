import java.util.*;
public class Kakao2017_32 {

	public static void solution (String msg){
		ArrayList<String> dic = new ArrayList();
		ArrayList<Integer> print = new ArrayList();
		
		// 1. ���� �ʱ�ȭ
		for(char c=65; c<=90; c++)
			dic.add(String.valueOf(c));
		
		// 2. ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w ã��
		String remain = msg;
		
		while(!remain.equals("")){
			Root_for :
				for(int i=remain.length(); i>=0; i--){
					String temp = remain.substring(0, i);
					for(String d : dic){
						if(d.equals(temp)){
							String w = temp;
							print.add(dic.indexOf(d)+1);
							remain = remain.substring(i);
							if(!remain.equals(""))
								dic.add(w+remain.substring(0, 1));
							break Root_for;
						}
					}
				}
		}
		
		System.out.println(print);
		
	}
	
	public static void main(String[] args) {
		solution("KAKAO");
		solution("TOBEORNOTTOBEORTOBEORNOT");
		solution("ABABABABABABABAB");
	}

}
