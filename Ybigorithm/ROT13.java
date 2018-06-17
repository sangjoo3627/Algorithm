import java.util.*;

public class ROT13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++){
			char astr = str.charAt(i);
			if(astr >= 65 && astr <= 90){
				astr += 13;
				if(astr > 90)
					astr -= 26;
				System.out.print(astr);
			}
			else if (astr >= 97 && astr <= 122){
				astr += 13;
				if(astr > 122)
					astr -= 26;
				System.out.print(astr);
			}
			else {
				System.out.print(astr);
			}
		}

	}

}
