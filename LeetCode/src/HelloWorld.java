import java.util.*;


public class HelloWorld {
	static boolean flag;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void checkTree (TreeNode a, TreeNode b){
		if(a == null && b == null) return;
		if(a.val == b.val){
			if(a.left != null && b.left != null) checkTree(a.left, b.left);
			if(a.right != null && b.right != null) checkTree(a.right, b.right);
		}
		else flag = false;
	}
	
	public static boolean isEqualTree (TreeNode a, TreeNode b){
		flag = true;
		checkTree(a,b);
		if(flag) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode (1);
		TreeNode b = new TreeNode (1);
		
		a.left = new TreeNode (1);
		b.left = new TreeNode (1);
		
		Set <TreeNode> set = new HashSet();
		set.add(a);
		set.add(b);
		
		if(isEqualTree(a,b)) System.out.println("yes");
	}

}
