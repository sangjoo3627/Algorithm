/*
 * 다리 만들기
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
	
	// 번호 붙이기 bfs
	public static void bfs(Pair v, int N){
		if(map[v.x][v.y] == 0) return;
		
		Queue <Pair> q = new LinkedList();
		q.add(v);
		cnt++;
		
		while(!q.isEmpty()){
			Pair t = q.remove();
			d[t.x][t.y] = cnt;
			
			// 동서남북 육지인 곳을 BFS로 찾아 탐색 후 번호 붙이기
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
	
	
	// 짧은 다리 찾기 bfs
	public static void bfs_(Pair v, int N, int k){
		if(map[v.x][v.y] == 0) return;
		
		Queue <Pair> q = new LinkedList();
		q.add(v);
		
		while(!q.isEmpty()){
			Pair t = q.remove();
			temp[t.x][t.y] = k;
			
			// 동서남북 육지인 곳을 BFS로 찾아 탐색 후 비어있으면 확장
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
		
		// map에서 육지인 점을 하나 찾아 시작점으로 BFS start
		root_for:
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++)
				if(map[i][j] == 1){
					bfs(new Pair(i,j), n);
					break root_for;
				}
		}
		
		// 방문 안했지만 육지인 곳을 찾아 단지번호 붙이기 -> 연결요소
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++)
				if(d[i][j] == 0)
					bfs(new Pair(i,j), n);
		}
		
		/*
		// 가장 짧은 다리 구하기 -> 땅을 확장시키다가 다른 땅과 만날때 stop
		int landNum = cnt;
		int result = 0;
		for(int k=1; k<=landNum; k++){
			min = 0;
			
			// temp [][] 초기화
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
