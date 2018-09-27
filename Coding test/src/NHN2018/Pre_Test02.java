package NHN2018;
import java.util.*;

/*
 * NHN �����׽�Ʈ2
 * 
 * 	��� ���Ұ� 0 �Ǵ� 1�� ����� �ֽ��ϴ�.

	1�� ǥ�õ� ���Ҵ� ������ ��Ÿ���ϴ�.
	���⿡�� �����¿쿡 ������ 1�� ���� �����̶�� �����մϴ�.
	�� ������ ũ��� 1�� ������ �����մϴ�.
	
	�־��� N x N ũ���� ��Ŀ��� ������ ������ �� ������ ũ�⸦ ������������ ����ϼ���.
 */

class Pair {
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Pre_Test02 {
	
	static int cnt;
	static int [][] map;
	static int [][] area;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new int [n][n];
		area = new int [n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				area[i][j] = 0;
			}
		}
		
		List<Integer> arr = new LinkedList<>();
		cnt = 0;
		int start_row, start_col;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (area[i][j] == 0 && map[i][j] == 1) {
					int temp = bfs(new Pair(i, j), n);
					arr.add(temp);
				}
		}
		
		System.out.println(cnt);
		
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i));
			if(i != arr.size()-1) System.out.print(" ");
			else System.out.println();
		}
	}
	
	public static int bfs(Pair v, int N){
		if(map[v.x][v.y] == 0) return 0;
		
		int num = 0;
		Queue <Pair> q = new LinkedList();
		q.add(v);
		cnt++;
		
		while(!q.isEmpty()){
			Pair t = q.remove();
			if(area[t.x][t.y] == 0)
				num++;
			area[t.x][t.y] = cnt;
			
			if(t.x+1 < N && map[t.x+1][t.y] == 1 && area[t.x+1][t.y] == 0) 
				q.add(new Pair(t.x+1, t.y));
			if(t.y+1 < N && map[t.x][t.y+1] == 1 && area[t.x][t.y+1] == 0) 
				q.add(new Pair(t.x, t.y+1));
			if(t.x-1 >=0 && map[t.x-1][t.y] == 1 && area[t.x-1][t.y] == 0) 
				q.add(new Pair(t.x-1, t.y));
			if(t.y-1>=0 && map[t.x][t.y-1] == 1 && area[t.x][t.y-1] == 0) 
				q.add(new Pair(t.x, t.y-1));
		}
		return num;
	}

}
