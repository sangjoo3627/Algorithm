/*
 * Problem #214 Shortest Palindrome
 * 
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * Example
 * Input : "abcd"
 * Output : "dcbabcd"
 * 
 * 25%
 */

public class p214 {
	/*
	 * 접근방법 :
	 * 첫번째 index부터 시작하는 palindromic한 string을 찾으면 나머지 suffix를 앞에 거꾸로 붙여넣는다.
	 * 첫번째 index부터 시작하는게 아니면 의미가 없다. 그냥 처음부터 모든 string을 거꾸로 붙이는 것과 마찬가지기 때문
	 * 즉 j를 0으로 두고 string의 end부터 비교해보면 같은 문자를 찾고
	 * 같은 문자를 찾으면 j++ 하여 palindrome을 찾는다.
	 * 만약 j==s.length()가 된다면 문자 전체가 palindrome하다고 볼 수 있으므로 string 전체를 리턴하고
	 * 아니라면 그뒤의 suffix를 구해 앞에 reverse하여 붙여넣고
	 * palindrome + suffix를 리턴한다.
	 */
	
	public static String shortestPalindrome(String s) {
		int j=0;
		for(int i=s.length()-1; i>=0; i--){
			if(s.charAt(i) == s.charAt(j)) j++;
		}
		if(j==s.length()) return s;
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
	
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("cbbd"));
		
	}

}
