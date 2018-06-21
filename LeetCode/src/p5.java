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
	 * ���ٹ�� :
	 * 
	 * Max string length ���� ������ �ϳ��� ���̸� ����� �ִ� ��� string subset�� �����Ѵ�.
	 * �׸��� �� string subset�� palindromic ���� �Ǵ��ϴ� �Լ��� �����Ѵ�.
	 * �Լ��� ù index, ������ index���� ���� ������ �߾ӿ� ���������� ���ڰ� ������ true (O(1/2n))
	 * �� subset ���ϴ� �ð��� n(n+1)/2�̹Ƿ� �ð����⵵�� O(n^3)
	 * Time limit�� �ɸ��پ˾Ҵµ� �ΰ��̷� Accepted�� ��
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