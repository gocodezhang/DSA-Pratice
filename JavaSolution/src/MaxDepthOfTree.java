public class MaxDepthOfTree {
    public static int maxDepth(TreeNode root) {
        int[] result = new int[]{0};
        dfs(root, 0, result);
        return result[0];
    }
    public static void dfs(TreeNode currNode, int currDepth, int[] result) {
        // base case
        if (currNode == null) {
            if (currDepth > result[0]) {
                result[0] = currDepth;
            }
            return;
        }
        // recursive case
        dfs(currNode.left, currDepth + 1, result);
        dfs(currNode.right, currDepth + 1, result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}
