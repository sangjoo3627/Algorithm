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
	 * 접근방법
	 * 수학의 조합 문제와 같으나 구현하는데 살짝 애먹음
	 * 일단 숫자와 연결된 각 알파벳들을 저장할 keys라는 배열을 만들어준다
	 * 그리고 helper() 함수를 따로 만들어 인자로 prefix, digits, offset, List를 넘긴다
	 * 여기서 offset은 digits의 각 인덱스를 의미한다 (0부터 digits.length까지)
	 * digits을 한자리로 쪼갠 후 이 값에 해당하는 keys를 가져와 재귀로 넘긴다
	 * 만약 offset이 총 길이 끝까지 닿으면 이 문자열을 리스트에 추가하고 리턴
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
