import java.util.*;
/*
 * Problem #102 Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
		3
	   / \
	  9  20
	    /  \
	   15   7
	
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	44%
 */

public class p102 {
	/*
	 * ���ٹ�� 
	 * BFS�� Ž���ϸ鼭 �� ������ ������ queue���� ���� ����Ʈ�� ����� 
	 * �� ������ child���� queue�� �ִ´�.
	 * while�� �ȿ��� queue�� size�� ���� for�� �����°� �������ؼ� ��������...
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode rt = new TreeNode (3);
		rt.left = new TreeNode(9);
		rt.right = new TreeNode(20);
		rt.right.left = new TreeNode(15);
		rt.right.right = new TreeNode(7);
		
		System.out.println(levelOrder(rt).toString());
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList();

        if(root == null) return result;
        
        // ù queue�� root�� �ְ� ����
        q.add(root);
        while(!q.isEmpty()){
        	// queue�� ���� ������ �ش� ������ �����ϴ� �� Node�� ���� �ǹ�
        	int levelNum = q.size();
        	List<Integer> lv = new LinkedList();
        	
        	for(int i=0; i<levelNum; i++){
        		TreeNode temp = q.poll();
        		lv.add(temp.val);
            	
            	if(temp.left != null) 	q.add(temp.left);
            	if(temp.right != null)	q.add(temp.right);
        	}
        	result.add(lv);
        }
        
        return result;
    }

}
