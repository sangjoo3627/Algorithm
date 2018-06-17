import java.util.*;

public class SuffixArray{

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str = sc.next();
		
		ArrayList <String> list = new ArrayList<String>();
		
		for(int i=0; i<str.length(); i++)
			list.add(str.substring(i, str.length()));
		
		Collections.sort(list);
		
		for(int j=0; j<list.size(); j++)
			System.out.println(list.get(j));
		
	}
	
	

}
