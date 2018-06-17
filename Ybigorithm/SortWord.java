import java.util.*;

public class SortWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();

		ArrayList <String> list = new ArrayList<String>();
		
		for(int i=0; i<N; i++){
			String str = sc.next();
			list.add(str);
		}

		Collections.sort(list, new namelength());
		
		int i=0;
		for(int j=1; j<=50; j++){
			ArrayList <String> newlist = new ArrayList <String>();
			while(i< list.size()){
				if(list.get(i).length() != j) break;
				else{
					if(!newlist.isEmpty()){
						if(!newlist.get(newlist.size()-1).equals(list.get(i)))
							newlist.add(list.get(i));
					}
					else newlist.add(list.get(i));
					
					i++;
				}
			}
			Collections.sort(newlist);
			
			for(int k=0; k<newlist.size(); k++)
				System.out.println(newlist.get(k));
		}
	}
}

class namelength implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
		return s1.length() > s2.length() ? 1
				: s1.length() < s2.length() ? -1 : 0;
	}
	
}
