import java.util.*;

/*
 * Problem #688 Knight Probability in Chessboard
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. 
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, 
 * then one square in an orthogonal direction.
 * 
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
 * Return the probability that the knight remains on the board after it has stopped moving.
 * 
 * Example:
	Input: 3, 2, 0, 0
	Output: 0.0625
	Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
	From each of those positions, there are also two moves that will keep the knight on the board.
	The total probability the knight stays on the board is 0.0625.
 * 
 * 40%
 */

public class p688 {
	/*
	 * 접근방법 : 
	 * 확률을 구하는 것이므로 총 가능한 가짓수는 8^k라 할수 있다 (가능한 방향 8가지, 움직이는 횟수 k개)
	 * 이제 k번 움직인 후에도 보드 위에 있는 경우의 수를 구한 값에 8^k로 나눠주면 확률을 구할 수 있다.
	 * 처음에는 재귀로 모든 경우의 수가 나올때마다 특정한 변수를 ++ 시켜서 횟수를 추가하려했지만
	 * 이 방식으로는 stackoverflow가 발생해 비효율적인 방법이란 걸 알게됨
	 * 
	 * dp를 이용해서 불필요한 연산 횟수를 줄여 문제를 해결
	 * dp[k+1][N][N]
	 * dp[k][i][j] = (i,j)에서 k번 움직였을때 보드 위에 있을 총 경우의 수
	 * 
	 * 즉 재귀를 통해 k-1, 8가지 move로 인자를 넘기고 k==0인 순간이 됬을시 1을 return 해 카운트해준다
	 * 만약 보드 밖으로 나가는 범위이면 0을 return
	 */
	static int [][] moves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
	
	public static void main(String[] args) {
		System.out.println(knightProbability(3,2,0,0));
	}
	
	public static double knightProbability(int N, int K, int r, int c) {
        double total = Math.pow(8.0, K);
        double [][][] dp = new double[K+1][N][N];
        return helper(dp, N, K, r, c) / total;
    }
	
	public static double helper (double [][][] dp, int N, int k, int r, int c){
		if(r < 0 || r >= N || c < 0 || c >= N) return 0.0;
		if(k == 0) return 1.0;
		if(dp[k][r][c] != 0.0) return dp[k][r][c];
		
		for(int i=0 ; i<8; i++)
			dp[k][r][c] += helper(dp, N, k-1, r+moves[i][0], c+moves[i][1]);
		return dp[k][r][c];
	}

}
