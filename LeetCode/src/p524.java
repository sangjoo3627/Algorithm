import java.util.*;

/*
 * Problem #524 Longest Word in Dictionary through Deleting
 * 
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. 
 * If there are more than one possible results, return the longest word with the smallest lexicographical order. 
 * If there is no possible result, return the empty string.
 * 
 * Example 1:
	Input:
	s = "abpcplea", d = ["ale","apple","monkey","plea"]
	
	Output: 
	"apple"
 * 
 * 43%
 */

public class p524 {
	/*
	 * ���ٹ��
	 * dictionary���� �ϳ��� �ܾ ���� �־��� string s�� ���ԵǴ� �������� �Ǵ��Ѵ�
	 * �̰��� �Ǵ��ϱ� ����
	 * dicWord�� index�� i���� �ϳ� �ΰ� s�� �� ���ڸ� Ž���ϸ鼭 dicWord[i]�� ��ġ�ϸ� i++���ְ� �ƴϸ� �������ڷ� ��ŵ
	 * �̷��� Ž���� ���� �� i���� dicWord�� ���̿� ���ٸ� �츮�� ã�����ϴ� ���ڸ� ã����
	 * ���� longest�ϰ� smallest lexicographical order�� ���� �Ǵ��� ������� update���ش�
	 * 
	 * ** String���� compareTo �Լ��� ���� ������ ������ �Ǵ��� �� �ִ�
	 */

	public static void main(String[] args) {
		String s = "abpcplea";
		String [] dic = {"ale","apple","monkey","plea"};
		
		List<String> d = new LinkedList<>(Arrays.asList(dic));
		System.out.println(findLongestWord(s,d));
	}
	
	public static String findLongestWord(String s, List<String> d) {
        String result = "";
        
        for(String dicWord : d) {
        	if(dicWord.length() > s.length()) continue;
        	
        	// dicWord�� i�� �� Ž���ϸ鼭 string s�� ���ԵǴ� string���� �Ǻ�
        	int i=0;
        	for(char c : s.toCharArray()) 
        		if(i < dicWord.length() && c == dicWord.charAt(i)) i++;
        	
        	// �־��� string s�� ����� �ִ� string�� ã�Ҵٸ�
        	if(dicWord.length() == i) {
        		// ���̰� �� �� ������ update
        		if(result.length() < i) result = dicWord;
        		// ���̰� ���ٸ� smallest lexicographical order���� �Ǵ��ϰ� update
        		else if(result.length() == i) {
        			if(dicWord.compareTo(result) < 0) result = dicWord;
        		}
        	}
        }
        
        return result;
    }
}
