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
	 * 접근방법2
	 * 
	 * DP로 접근, dp[i][j]는 dp[i+1][j-1]이 true이고 str[i] == str[j] 이면 true
	 * 즉 dp[i][i]는 자연스레 true로 설정할 수 있으므로
	 * for문을 두개 돌리면서 dp를 채워나갈수 있다.
	 * 해당 string의 max값을 계산해 update해주고 마지막 update된 longest string을 반환해준다.
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
				String temp = s.substring(j, j+i);
				if(i==2 && s.charAt(j) == s.charAt(j+1)) {
					dp[j][j+1] = true;
					longest = temp;
					continue;
				}
				if(dp[j+1][j+i-2] && s.charAt(j) == s.charAt(j+i-1)) {
					dp[j][j+i-1] = true;
					if(max < i) {
						max = i;
						longest = temp;
					}
				}
			}
		}
        
        return longest;
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
	}

}
