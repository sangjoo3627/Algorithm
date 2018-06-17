import java.util.*;
import java.io.*;

public class test {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (new File ("input.txt"));
		PrintWriter output = new PrintWriter (new FileWriter("output2.txt"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int f = sc.nextInt();
		
		output.println(n + " " + m);
		output.println(13 + " " + 466666);
		
		
		int count = 0;
		for(int i=0; i<m; i++){
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			output.println(u + " " + v + " " + (50+i));
		}
		
	}
}