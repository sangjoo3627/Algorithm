import java.util.*;

/*
 * Problem #449 Serialize and Deserialize BST
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * 
 * 42.9%
 */

public class p449 {
	/*
	 * ���ٹ��
	 * 
	 * Serialize :
	 * tree�� level���� node���� ������ �̾���δ�
	 * queue�� �̿��� left, right�� �߰��ϰ� poll �ϴ� ������ serialize�� �ϰ�
	 * null �̸� "#"�� ����, "," �����ڷ� string�� �̾���δ�
	 * 
	 * Deserialize :
	 * input���� ���� string�� "," �����ڷ� split �ϰ� ù��° ��Ҹ� �����´�
	 * �ٽ� queue�� �����ϰ� i=1 ���� ������ string�� �ε��� ������ �����Ѵ�
	 * i���� ������Ű�� poll �� queue�� ����� left, right�� �ǹ� �ϹǷ�
	 * ������ left, right�� node�� �����ϰ� �߰��Ͽ� �ڽĳ��� �����Ѵ�.
	 */
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static class Codec {

		// Encodes a tree to a single string.
		public static String serialize(TreeNode root) {
			if(root == null) return "";
			StringBuilder serial = new StringBuilder();
			
			Queue <TreeNode> q = new LinkedList();
			q.add(root);
			while(!q.isEmpty()){
				TreeNode n = q.poll();
				if(n != null){
					serial.append(n.val + ",");
					q.add(n.left);
					q.add(n.right);
				}
				else{
					serial.append("#,");
				}
			}
			serial.substring(0, serial.length()-1);
			return serial.toString();
		}

		// Decodes your encoded data to tree.
		public static TreeNode deserialize(String data) {
			if(data == null || data.length() == 0) return null;
			
			String [] arr = data.split(",");
			String cur = arr[0];
			TreeNode n = new TreeNode(Integer.parseInt(cur));
			
			Queue <TreeNode> q = new LinkedList();
			q.add(n);
			
			int i=1;
			while(!q.isEmpty()){
				TreeNode m = q.poll();
				
				if(!arr[i].equals("#")){
					m.left = new TreeNode(Integer.parseInt(arr[i]));
					q.add(m.left);
				}
				i++;
				
				if(!arr[i].equals("#")){
					m.right = new TreeNode(Integer.parseInt(arr[i]));
					q.add(m.right);
				}
				i++;
			}
			return n;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(4);
		
		Codec codec = new Codec();
		System.out.println(codec.serialize(root));
	}

}
