public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int remaining = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return remaining == 0;
        }
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        System.out.println(hasPathSum(root, 4));
    }
}
