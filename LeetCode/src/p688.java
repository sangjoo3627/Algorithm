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
	 * ���ٹ�� : 
	 * Ȯ���� ���ϴ� ���̹Ƿ� �� ������ �������� 8^k�� �Ҽ� �ִ� (������ ���� 8����, �����̴� Ƚ�� k��)
	 * ���� k�� ������ �Ŀ��� ���� ���� �ִ� ����� ���� ���� ���� 8^k�� �����ָ� Ȯ���� ���� �� �ִ�.
	 * ó������ ��ͷ� ��� ����� ���� ���ö����� Ư���� ������ ++ ���Ѽ� Ƚ���� �߰��Ϸ�������
	 * �� ������δ� stackoverflow�� �߻��� ��ȿ������ ����̶� �� �˰Ե�
	 * 
	 * dp�� �̿��ؼ� ���ʿ��� ���� Ƚ���� �ٿ� ������ �ذ�
	 * dp[k+1][N][N]
	 * dp[k][i][j] = (i,j)���� k�� ���������� ���� ���� ���� �� ����� ��
	 * 
	 * �� ��͸� ���� k-1, 8���� move�� ���ڸ� �ѱ�� k==0�� ������ ������ 1�� return �� ī��Ʈ���ش�
	 * ���� ���� ������ ������ �����̸� 0�� return
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
