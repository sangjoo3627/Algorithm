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

public class p5 {
	/*
	 * 접근방법 :
	 * 
	 * Max string length 부터 시작해 하나씩 줄이며 만들수 있는 모든 string subset을 생성한다.
	 * 그리고 각 string subset이 palindromic 한지 판단하는 함수를 실행한다.
	 * 함수는 첫 index, 마지막 index에서 각각 시작해 중앙에 만날때까지 문자가 같으면 true (O(1/2n))
	 * 총 subset 구하는 시간이 n(n+1)/2이므로 시간복잡도는 O(n^3)
	 * Time limit이 걸릴줄알았는데 턱걸이로 Accepted는 됨
	 * 
	 * O(n^3)
	 */
	public static boolean checkPalindromic (String str){
		for(int i = 0 ,j = str.length()-1; i <= j; i++, j--)
			if(str.charAt(i) != str.charAt(j)) return false;
		return true;
	}
	
	public static String longestPalindrome(String s) {
		if(s.length() <= 1) return s;
		
        int len = s.length();
        for(int i=len; i>=1; i--){
        	for(int j=0; j<=s.length()-i; j++){
        		String temp = s.substring(j, j+i);
        		if(checkPalindromic(temp)) return temp; 
        	}
        }
        return s.substring(s.length()-1);
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("bbacaabbdd"));
	}

}