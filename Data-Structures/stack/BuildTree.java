package stack;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class BuildTree {
	static int preIndex = 0;
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return constructBinaryTree(preorder, inorder, 0, inorder.length - 1, inmap);
    }
	private static TreeNode constructBinaryTree(int[] preorder, int[] inorder, int is, int ie, Map<Integer, Integer> inmap) {
        if (is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int inIndex = inmap.get(root.val);

        preIndex++;

        root.left = constructBinaryTree(preorder, inorder, is, inIndex - 1, inmap);
        root.right = constructBinaryTree(preorder, inorder, inIndex + 1, ie, inmap);

        return root;
    }
	public static void preorder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode root = buildTree(preorder, inorder);
        preorder(root);

	}

}
