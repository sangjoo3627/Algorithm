package BackTracking;
import java.util.*;

/*
 * Problem #1987 알파벳
 * 
 * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 * 
	입력
	첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1<=R,C<=20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.
	
	출력
	첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.
 */

public class p1987 {

	/*
	 * 접근방법
	 * 해쉬셋으로 지나온 알파벳들을 저장해서 중복되지 않는지 판단한다
	 * 만약 움직이는 위치가 맵 상을 벗어났거나 중복된 알파벳이라면 다시 돌아오는 백트래킹 방법을 쓴다
	 * 여기서 중요한 것은 맨 마지막에 안 움직였을 경우를 코드 추가해줘야한다는것!! (이것 때문에 뻘짓함...)
	 */
	
	static int R,C,result;
	static String [][] map;
	static Set<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		set = new HashSet<>();
		
		map = new String[R][C];
		for(int i=0; i<R; i++){
			String s = sc.next();
			for(int j=0; j<C; j++){
				char temp = s.charAt(j);
				map[i][j] = Character.toString(temp);
			}
		}
		
		dfs(0,0,1);
		System.out.println(result);
	}

	public static void dfs (int r, int c, int nums){
		if(r>=R || r<0 || c>=C || c<0) return;	// 맵상 벗어났을때
		if(set.contains(map[r][c])) return;		// 중복된 알파벳일때
		else {
			set.add(map[r][c]);		
			result = Math.max(result, nums);	// 움직였다면 거리를 +1하고 최대거리를 update
			nums++;
		}
		
		// 남동북서 방향으로 움직임
		dfs(r+1, c, nums);
		dfs(r, c+1, nums);
		dfs(r-1, c, nums);
		dfs(r, c-1, nums);
		
		// 안 움직였을 경우
		set.remove(map[r][c]);
		nums--;
	}
}
