import java.util.*;

public class FindAlpa {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str = sc.next();
		
		// 소문자만
		for(int i=97; i<=122; i++){
			boolean check = false;
			for(int j=0; j<str.length(); j++){
				if(str.charAt(j) == (char)i){
					System.out.print(j);
					check = true;
					break;
				}
			}	
			if(!check) System.out.print(-1);
			if(i != 122) System.out.print(" ");
		}
	}

}
