import java.util.*;

/*
 * Problem #230
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Input : root = [3,1,4,null,2], k=1
 * 		3
 * 	  /   \
 *   1     4
 *    \
 *     2
 * 
 * Output : 1
 * 
 * 45%
 */

public class p230 {
	
	/*
	 * 접근방식:
	 * Binary Search Tree 이므로 왼쪽 SubTree는 항상 해당 노드보다 값이 작다.
	 * 이 성질을 이용하여 root에서 left node로 내려가면서 가장 작은 값을 찾고
	 * 반대로 올라오면서 k번째 smallest 값을 찾는 방식
	 * helper()라는 recursive 함수를 이용해
	 * left node가 null일때까지 left node를 찾아 내려가면 smallest 값을 찾고
	 * k값을 줄이고 right node도 탐색하면서 kth smallest 값을 찾는다
	 * 
	 */
	static int res;
	static int kk;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void helper(TreeNode node){
		if (node == null) return;
		helper(node.left);
		kk--;
		if(kk == 0){
			res = node.val;
			return;
		}
		helper(node.right);
	}

	public static int kthSmallest(TreeNode root, int k) {
        if(root.left == null && root.right == null) return root.val;
        kk = k;
        helper(root);
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		System.out.println(kthSmallest(root, 1));
	}

}
