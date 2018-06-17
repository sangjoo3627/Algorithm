import java.util.*;

public class Editor {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		StringBuffer str = new StringBuffer();
		str.append(sc.next());
		int N = sc.nextInt();
		int cur = str.length();
		
		
		for(int i=0; i<N; i++){
			String ins = sc.next();
			
			if(ins.equals("P")){
				String s = sc.next();
				if(str.length() > 0)
					str.insert(cur, s);
					//str = str.substring(0, cur) + s + str.substring(cur);
				else
					str.append(s);
				if(cur+1 <= str.length())
					cur++;
			}
			else if(ins.equals("L")){
				if(cur-1 >= 0)
					cur--;
			}
			else if(ins.equals("D")){
				if(cur+1 <= str.length())
					cur++;
			}
			else if(ins.equals("B")){
				if(str.length() > 0 ){
					if(cur != 0)
						str.deleteCharAt(cur-1);
						//str = str.substring(0, cur-1) + str.substring(cur);
					if(cur-1 >= 0)
						cur--;
				}
			}
		}
		
		sc.close();
		System.out.println(str);

	}

}
