/*
 * Problem #652 Find Duplicate Subtrees
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 * 
 * Example
 *      1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
 * 
 * The following are two duplicate subtrees:
 * 
 * 	  2
     /		and		4
    4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
 * 
 * 37.5%
 */

import java.util.*;
public class p652 {
	/*
	 * 접근방법 :
	 * 
	 * postorder로 BST를 탐색 후 각각의 subtree를 구해 중복인지 판단 후 result list에 추가한다
	 * 중복인지 판단하는 방법은 각 subtree를 postorder로 돌면서 값들을 String 값에 추가하면서 하나의 serial을 만드는 개념이다
	 * 즉 이 String serial이 같으면 두 subtree가 같다고 판단
	 * 
	 */ 
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res){
		// null을 만났을 경우는 "#"로 대체하여 String에 추가
		if(cur == null) return "#";
		// postorder 순으로 serial을 string 형태로 만들어준다.
		String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
		// 해당 값이 중복해서 1개 존재한다면 res에 결과값을 추가해준다 (2개면 이미 추가했다는 것을 의미하므로 패스)
		if(map.getOrDefault(serial, 0) == 1) res.add(cur);
		// HashMap에 key=serial, val=개수 로 저장, 즉 중복이 나올때마다 1씩 추가하여 저장
		map.put(serial, map.getOrDefault(serial, 0)+1);
		return serial;
	}
	
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new LinkedList();
		postorder(root, new HashMap<>(), result);
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(0);

		for(TreeNode n : findDuplicateSubtrees(root)){
			System.out.print(n.val + " ");
		}
	}

}