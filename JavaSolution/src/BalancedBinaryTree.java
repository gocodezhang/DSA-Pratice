public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode node) {
        // if (node is null)
        if (node == null) {
            // return true
            return true;
        }

        // calculate height for left
        int leftHeight = computeHeight(node.left);
        // calculate height for right
        int rightHeight = computeHeight(node.right);
        // check if heightLeft != heightRight
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // return false
            return false;
        }

        // return isBalanced(left) && isBalanced(right)
        return isBalanced(node.left) && isBalanced(node.right);
    }
    public static int computeHeight(TreeNode node) {
        // base case
        // if node is null
        if (node == null) {
            return -1;
        }
        // recursive case
        // computeHeight(node.left)
        int left = computeHeight(node.left);
        // computeHeight(node.right)
        int right = computeHeight(node.right);

        // return Max(left, right) + 1;
        return Math.max(left, right) + 1;
    }
    public static boolean isBalanced2(TreeNode root) {
        return dfs(root)[0] == 1;
    }
    public static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{1, -1};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[0] == 0 || right[0] == 0 || Math.abs(left[1] - right[1]) > 1) {
            return new int[]{0, Math.max(left[1], right[1]) + 1};
        }
        return new int[]{1, Math.max(left[1], right[1]) + 1};
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(20);
        TreeNode node31 = new TreeNode(15);
        TreeNode node32 = new TreeNode(7);

        node1.left = node21;
        node1.right = node22;
        node21.left = node31;
        node21.right = node32;

        System.out.println(isBalanced2(node1));
    }
}
