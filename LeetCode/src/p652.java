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
	 * ���ٹ�� :
	 * 
	 * postorder�� BST�� Ž�� �� ������ subtree�� ���� �ߺ����� �Ǵ� �� result list�� �߰��Ѵ�
	 * �ߺ����� �Ǵ��ϴ� ����� �� subtree�� postorder�� ���鼭 ������ String ���� �߰��ϸ鼭 �ϳ��� serial�� ����� �����̴�
	 * �� �� String serial�� ������ �� subtree�� ���ٰ� �Ǵ�
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
		// null�� ������ ���� "#"�� ��ü�Ͽ� String�� �߰�
		if(cur == null) return "#";
		// postorder ������ serial�� string ���·� ������ش�.
		String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
		// �ش� ���� �ߺ��ؼ� 1�� �����Ѵٸ� res�� ������� �߰����ش� (2���� �̹� �߰��ߴٴ� ���� �ǹ��ϹǷ� �н�)
		if(map.getOrDefault(serial, 0) == 1) res.add(cur);
		// HashMap�� key=serial, val=���� �� ����, �� �ߺ��� ���ö����� 1�� �߰��Ͽ� ����
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