import java.io.*;
import java.util.*;
class Line2018_2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		
		// Canvas
		sc.next(); sc.next();
		System.out.println(sc.nextInt());
		sc.next();
		System.out.println(sc.nextInt());
		
		// Background color
		sc.next(); sc.next();
		String bc = sc.next();
		bc = bc.substring(2);
		System.out.println(Integer.valueOf(bc, 16));
		
		// number of frames
		sc.next(); sc.next(); sc.next();
		int num = sc.nextInt();
		System.out.println(num);
		
		// Name of property
		sc.nextLine(); sc.nextLine();
		
		// frames
		for(int i=0; i<num; i++){
			sc.next();
			int width = sc.nextInt();
			int height = sc.nextInt();
			System.out.print(width+"x"+height+", ");
			String alpha = sc.next();
			int al;
			if(alpha.equals("yes")) al = 1;
			else al = 0;
			int duration = sc.nextInt();
			System.out.print(duration+", "+al);
			System.out.println();
		}
	}
}