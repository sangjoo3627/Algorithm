/*
 * Problem #648 Replace Words
 * 
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. 
 * For example, the root an, followed by other, which can form another word another
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 * You need to output the sentence after the replacement.
 * 
 * Example:
 * 	Input: dict = ["cat", "bat", "rat"]
	sentence = "the cattle was rattled by the battery"
	Output: "the cat was rat by the bat"
 * 
 * 47%
 */
import java.util.*;
public class p648 {
	public static String replaceWords(List<String> dict, String sentence) {
        String result = "";
        String [] words = sentence.split(" ");
        
        // dict 요소들을 length 별로 나눈 후 전탐색한 방법 262ms
        int max = 0;
        for(String s : dict) if(s.length() > max) max = s.length();
        ArrayList <String> [] arr = new ArrayList[max+1];
        
        for(int i=0; i<arr.length; i++)
        	arr[i] = new ArrayList();
   
        for(String s : dict) {
        	int len = s.length();
        	arr[len].add(s);
        }
        
        for(int i=0; i<words.length; i++){
        	int len = words[i].length();
        	int min = Integer.MAX_VALUE;
        	for(int j=0; j<arr.length; j++){
        		for(String s : arr[j]){
        		if(words[i].length() > s.length() && words[i].substring(0, s.length()).equals(s) && min > s.length()){
        			min = s.length();
        			words[i] = s;
        		}
        		}
        	}
        }
        
        
        /* 전탐색 방법 287ms
        for(int i=0; i<words.length; i++){
        	int min = Integer.MAX_VALUE;
        	for(String s : dict){
        		if(words[i].length() > s.length() && words[i].substring(0, s.length()).equals(s) && min > s.length()){
        			min = s.length();
        			words[i] = s;
        		}
        	}
        }
        */
        
        for(int i=0; i<words.length; i++){
        	result += words[i];
        	if(i != words.length-1) result += " ";
        }
        return result;
    }

	public static void main(String[] args) {
		List<String> dict = new ArrayList();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		System.out.println(replaceWords(dict, "the cattle was rattled by the battery"));
	}

}
