/*
 * Problem #72
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * 
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 * 
 * Example
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
  	horse -> rorse (replace 'h' with 'r')
	rorse -> rose (remove 'r')
	rose -> ros (remove 'e')
 * 
 * 33.1%
 */

public class p72 {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // dp[i][j]는 word1의 ith까지의 string에서 word2의 jth까지의 string으로 convert하는데 드는 cost
        int [][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = i;		// 하나씩 delete하는 cost
        for(int j=1; j<=m; j++) dp[0][j] = j;		// 하나씩 insert하는 cost
        
        for(int i=1; i<=n; i++){
        	for(int j=1; j<=m; j++){
        		if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
        		else{
        			int insert = dp[i][j-1];
        			int delete = dp[i-1][j];
        			int replace = dp[i-1][j-1];
        			dp[i][j] = insert<delete ? (insert<replace ? insert:replace) : (delete<replace ? delete:replace);
        			dp[i][j]++;
        		}
        	}
        }
        
        return dp[n][m];
    }
    
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(minDistance(word1,word2));
	}

}
