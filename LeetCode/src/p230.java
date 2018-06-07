import java.util.*;

/*
 * Problem #230
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 �� k �� BST's total elements.
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
	 * ���ٹ��:
	 * Binary Search Tree �̹Ƿ� ���� SubTree�� �׻� �ش� ��庸�� ���� �۴�.
	 * �� ������ �̿��Ͽ� root���� left node�� �������鼭 ���� ���� ���� ã��
	 * �ݴ�� �ö���鼭 k��° smallest ���� ã�� ���
	 * helper()��� recursive �Լ��� �̿���
	 * left node�� null�϶����� left node�� ã�� �������� smallest ���� ã��
	 * k���� ���̰� right node�� Ž���ϸ鼭 kth smallest ���� ã�´�
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
