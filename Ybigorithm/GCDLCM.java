import java.util.*;

public class GCDLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		sc.close();
		
		int r=1;
		int LCM;
		int t1 = n1, t2 = n2;
		if(n1<n2){
			n1 = t2;
			n2 = t1;
		}
		
		while(r>0){
			r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		
		LCM = t1*t2/n1;
		System.out.println(n1);
		System.out.println(LCM);
	}

}
