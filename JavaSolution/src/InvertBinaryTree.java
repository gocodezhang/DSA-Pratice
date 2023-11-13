import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        // when root == null
        if (root == null) {
            return null;
        }

        // create invertedRoot = new TreeNode(root.val)
        TreeNode invertedRoot = new TreeNode(root.val);
        // invertedRoot.left = invertTree(root.right)
        invertedRoot.left = invertTree(root.right);
        // invertedRoot.right = invertTree(root.left)
        invertedRoot.right = invertTree(root.left);

        // return invertedRoot
        return invertedRoot;
    }
    public static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode currNode = queue.poll();
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }

        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(invertTreeIterative(root));
    }
}
