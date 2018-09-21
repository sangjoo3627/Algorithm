import java.util.*;

/*
 * Problem #129 Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 * 
 * Example:

	Input: [1,2,3]
	    1
	   / \
	  2   3
	Output: 25
	Explanation:
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	Therefore, sum = 12 + 13 = 25.
 * 
 * 37%
 */

public class p129 {
	/*
	 * 접근방법
	 * 일반적인 dfs로 탐색하면서 leaf node를 만날때까지 숫자를 추가해준다
	 * leaf node임이 판단되면 결과값 sum에 더한다
	 */
	
	static int sum;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		
		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		sum = 0;
        dfs(root, 0);
        return sum;
    }
	
	public static void dfs (TreeNode node, int prefix){
		if(node == null) return;
		prefix = prefix*10 + node.val;
		
		if(node.left == null && node.right == null){
			sum += prefix;
			return;
		}
		
		if(node.left != null) dfs(node.left, prefix);
		if(node.right != null) dfs(node.right, prefix);
	}
}
