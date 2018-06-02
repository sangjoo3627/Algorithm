/*
 * �ٸ� �����
 */

package Connected_component;

import java.util.*;

class Pair {
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class p2146 {

	static int[][] map;
	static int[][] d;
	static int[][] temp;
	static int cnt=0;
	static int min=0;
	
	// ��ȣ ���̱� bfs
	public static void bfs(Pair v, int N){
		if(map[v.x][v.y] == 0) return;
		
		Queue <Pair> q = new LinkedList();
		q.add(v);
		cnt++;
		
		while(!q.isEmpty()){
			Pair t = q.remove();
			d[t.x][t.y] = cnt;
			
			// �������� ������ ���� BFS�� ã�� Ž�� �� ��ȣ ���̱�
			if(t.x+1 < N && map[t.x+1][t.y] == 1 && d[t.x+1][t.y] == 0) {
				q.add(new Pair(t.x+1, t.y));
				d[t.x+1][t.y] = cnt;
			}
			if(t.y+1 < N && map[t.x][t.y+1] == 1 && d[t.x][t.y+1] == 0) {
				q.add(new Pair(t.x, t.y+1));
				d[t.x][t.y+1] = cnt;
			}
			if(t.x-1 >=0 && map[t.x-1][t.y] == 1 && d[t.x-1][t.y] == 0) {
				q.add(new Pair(t.x-1, t.y));
				d[t.x-1][t.y] = cnt;
			}
			if(t.y-1>=0 && map[t.x][t.y-1] == 1 && d[t.x][t.y-1] == 0) {
				q.add(new Pair(t.x, t.y-1));
				d[t.x][t.y-1] = cnt;
			}
		}
	}
	
	
	// ª�� �ٸ� ã�� bfs
	public static void bfs_(Pair v, int N, int k){
		if(map[v.x][v.y] == 0) return;
		
		Queue <Pair> q = new LinkedList();
		q.add(v);
		
		while(!q.isEmpty()){
			Pair t = q.remove();
			temp[t.x][t.y] = k;
			
			// �������� ������ ���� BFS�� ã�� Ž�� �� ��������� Ȯ��
			if(t.x+1 < N && temp[t.x+1][t.y] == 0) {
				q.add(new Pair(t.x+1, t.y));
				temp[t.x+1][t.y] = k;
			}
			if(t.y+1 < N && temp[t.x][t.y+1] == 0) {
				q.add(new Pair(t.x, t.y+1));
				temp[t.x][t.y+1] = k;
			}
			if(t.x-1 >= 0 && temp[t.x-1][t.y] == 0) {
				q.add(new Pair(t.x-1, t.y));
				temp[t.x-1][t.y] = k;
			}
			if(t.y-1 >= 0 && temp[t.x][t.y-1] == 0) {
				q.add(new Pair(t.x, t.y-1));
				temp[t.x][t.y-1] = k;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// Create Map, d
		map = new int [n][];
		d = new int [n][];
		for(int i =0; i<n; i++){
			map[i] = new int[n];
			d[i] = new int[n];
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				d[i][j] = 0;
			}
		}
		
		// map���� ������ ���� �ϳ� ã�� ���������� BFS start
		root_for:
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++)
				if(map[i][j] == 1){
					bfs(new Pair(i,j), n);
					break root_for;
				}
		}
		
		// �湮 �������� ������ ���� ã�� ������ȣ ���̱� -> ������
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++)
				if(d[i][j] == 0)
					bfs(new Pair(i,j), n);
		}
		
		/*
		// ���� ª�� �ٸ� ���ϱ� -> ���� Ȯ���Ű�ٰ� �ٸ� ���� ������ stop
		int landNum = cnt;
		int result = 0;
		for(int k=1; k<=landNum; k++){
			min = 0;
			
			// temp [][] �ʱ�ȭ
			for(int i =0; i<n; i++){
				for(int j=0; j<n; j++)
					temp[i][j] = d[i][j];
			}
			
			sear_for:
				for(int i =0; i<n; i++){
					for(int j=0; j<n; j++)
						if(d[i][j] == k){
							bfs_(new Pair(i,j), n, k);
							break sear_for;
						}
				}
			
			if(result == 0) result = min;
			else if(result > min) result = min;
		}
		
		*/
		
		
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(d[i][j] + " ");
			System.out.println();
		}
		
	}

}
