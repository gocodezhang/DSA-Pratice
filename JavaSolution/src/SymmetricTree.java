import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode right3 = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = left3;
        right.right = right3;
        System.out.println(isSymmetric(root));
    }
}
