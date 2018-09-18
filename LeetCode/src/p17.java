import java.util.*;

/*
 * Problem #17 Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * Example:
	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

 * 35%
 */

public class p17 {
	/*
	 * ���ٹ��
	 * ������ ���� ������ ������ �����ϴµ� ��¦ �ָ���
	 * �ϴ� ���ڿ� ����� �� ���ĺ����� ������ keys��� �迭�� ������ش�
	 * �׸��� helper() �Լ��� ���� ����� ���ڷ� prefix, digits, offset, List�� �ѱ��
	 * ���⼭ offset�� digits�� �� �ε����� �ǹ��Ѵ� (0���� digits.length����)
	 * digits�� ���ڸ��� �ɰ� �� �� ���� �ش��ϴ� keys�� ������ ��ͷ� �ѱ��
	 * ���� offset�� �� ���� ������ ������ �� ���ڿ��� ����Ʈ�� �߰��ϰ� ����
	 */

	static String [] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		String str = "23";
		System.out.println(letterCombinations(str));
	}
	
	public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits.isEmpty()) return result;
        
        helper("", digits, 0, result);
        return result;
    }
	
	public static void helper (String prefix, String digits, int offset, List<String> ret){
		if(offset >= digits.length()){
			ret.add(prefix);
			return;
		}
		
		String letters = keys[digits.charAt(offset) - '0'];
		for(int i=0; i<letters.length(); i++){
			helper(prefix + letters.charAt(i), digits, offset+1, ret);
		}
	}
}
