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
	 * 접근방법
	 * dictionary에서 하나씩 단어를 꺼내 주어진 string s에 포함되는 문자인지 판단한다
	 * 이것을 판단하기 위해
	 * dicWord의 index인 i값을 하나 두고 s의 각 문자를 탐색하면서 dicWord[i]와 일치하면 i++해주고 아니면 다음문자로 스킵
	 * 이렇게 탐색을 끝낸 후 i값이 dicWord의 길이와 같다면 우리가 찾고자하는 문자를 찾은것
	 * 이제 longest하고 smallest lexicographical order인 것을 판단해 결과값을 update해준다
	 * 
	 * ** String에서 compareTo 함수를 쓰면 사전적 순서를 판단할 수 있다
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
        	
        	// dicWord를 i로 쭉 탐색하면서 string s에 포함되는 string인지 판별
        	int i=0;
        	for(char c : s.toCharArray()) 
        		if(i < dicWord.length() && c == dicWord.charAt(i)) i++;
        	
        	// 주어진 string s를 만들수 있는 string을 찾았다면
        	if(dicWord.length() == i) {
        		// 길이가 더 긴 것으로 update
        		if(result.length() < i) result = dicWord;
        		// 길이가 같다면 smallest lexicographical order인지 판단하고 update
        		else if(result.length() == i) {
        			if(dicWord.compareTo(result) < 0) result = dicWord;
        		}
        	}
        }
        
        return result;
    }
}
