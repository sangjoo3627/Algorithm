package BFS_DFS;
import java.util.*;

public class p3055 {
	
	static String [][] map;
	
	public static class Pair{
		int x;
		int y;
		
		Pair(){
			this.x=0;
			this.y=0;
		}
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		public void setXY(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Pair c = (Pair) obj;
			return (x == c.x && y == c.y);
		}
	}

	public static boolean checkindex(int R, int C, int i, int j){
		if(i >= R || i < 0) return false;
		if(j >= C || j < 0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		Pair D = new Pair();
		Pair S = new Pair();
		
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				String temp = sc.next();
				if(temp.equals("D")) D.setXY(i, j);
				else if(temp.equals("S")) S.setXY(i,j);
				map[i][j] = temp;	
			}
		}
		
		int time = 0;
		boolean find = true;
		
		while(find && !D.equals(S)){
			time++;
			
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					if(map[i][j].equals("*")){
						if(checkindex(R,C,i+1,j)){
							
						}
						else if(checkindex(R,C,i,j+1)){
							
						}
						else if(checkindex(R,C,i-1,j)){
							
						}
						else if(checkindex(R,C,i,j-1)){
							
						}
					}
				}
			}
			
		}
		
		if(find)
			System.out.println(time);
		else
			System.out.println("KAKTUS");
	}

}
