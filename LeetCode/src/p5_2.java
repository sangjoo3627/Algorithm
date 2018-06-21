/*
 * Problem #5
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Input : "babad"
 * Output : "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 25%
 */

public class p5_2 {
	/*
	 * ���ٹ��2
	 * 
	 * DP�� ����, dp[i][j]�� dp[i+1][j-1]�� true�̰� str[i] == str[j] �̸� true
	 * �� dp[i][i]�� �ڿ����� true�� ������ �� �����Ƿ�
	 * for���� �ΰ� �����鼭 dp�� ä�������� �ִ�.
	 * �ش� string�� max���� ����� update���ְ� ������ update�� longest string�� ��ȯ���ش�.
	 * 
	 * O(n^2)
	 */
	
	public static String longestPalindrome(String s) {
		if(s.length() <= 1) return s;
		
		int len = s.length();
		int max = Integer.MIN_VALUE;
		String longest = s.substring(len-1, len);
		
		boolean [][] dp = new boolean [len][len];
		for(int i=0; i<len; i++) dp[i][i] = true;
		
		for(int i=2; i<=len; i++){
			for(int j=0; j<=len-i; j++){
				if(i==2 && s.charAt(j) == s.charAt(j+1)) {
					dp[j][j+1] = true;
					continue;
				}
				if(dp[j+1][j+i-2] && s.charAt(j) == s.charAt(j+i-1)) {
					dp[j][j+i-1] = true;
				}
			}
		}
		
		for(int i=0; i<len; i++){
			for(int j=i; j<len; j++){
				if(dp[i][j] && j-i+1 > max){
					max = j-i+1;
					longest = s.substring(i, j+1);
				}
			}
		}
		
        return longest;
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babab"));
	}

}
