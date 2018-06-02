package Sort;
import java.util.*;
public class p1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<n; i++) hs.add(sc.next());
		
		int size = hs.size();
		String arr[] = new String[size];
		hs.toArray(arr);
		
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String s1, String s2){
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		for(int i=0; i<size; i++) {
			int len = arr[i].length();
			int j;
			for(j=i+1; j<size; j++){
				int tmp = arr[j].length();
				if(len != tmp) break;
			}
			Arrays.sort(arr,i,j);
			i = j-1;
		}
		
		for(int i=0; i<size; i++) System.out.println(arr[i]);
	}

}
