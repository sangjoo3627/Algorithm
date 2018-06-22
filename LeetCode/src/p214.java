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
	 * ���ٹ�� :
	 * ù��° index���� �����ϴ� palindromic�� string�� ã���� ������ suffix�� �տ� �Ųٷ� �ٿ��ִ´�.
	 * ù��° index���� �����ϴ°� �ƴϸ� �ǹ̰� ����. �׳� ó������ ��� string�� �Ųٷ� ���̴� �Ͱ� ���������� ����
	 * �� j�� 0���� �ΰ� string�� end���� ���غ��� ���� ���ڸ� ã��
	 * ���� ���ڸ� ã���� j++ �Ͽ� palindrome�� ã�´�.
	 * ���� j==s.length()�� �ȴٸ� ���� ��ü�� palindrome�ϴٰ� �� �� �����Ƿ� string ��ü�� �����ϰ�
	 * �ƴ϶�� �׵��� suffix�� ���� �տ� reverse�Ͽ� �ٿ��ְ�
	 * palindrome + suffix�� �����Ѵ�.
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
