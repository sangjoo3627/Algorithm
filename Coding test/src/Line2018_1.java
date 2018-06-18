import java.io.*;
import java.util.*;
class Line2018_1 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			int N = sc.nextInt();
			ArrayList <Double> B = new ArrayList();
			ArrayList <Double> C = new ArrayList();
			
			for(int j=0; j<N; j++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				String name = sc.next();
				
				double d = x*x+y*y;
				double dis = Math.sqrt(d);
				
				if(name.equals("Brown"))
					B.add(dis);
				else C.add(dis);
			}
			
			B.sort(null);
			C.sort(null);
			
			if(B.get(0) > C.get(0)){
				int sum=0;
				for(Double c : C)
					if(c < B.get(0)) sum++;
				
				System.out.println("Cony");
				System.out.println(sum);
			}
			else if(B.get(0) < C.get(0)){
				int sum=0;
				for(Double b : B)
					if(b < C.get(0)) sum++;
				
				System.out.println("Brown");
				System.out.println(sum);
			}
			
		}
		
		
	}
}