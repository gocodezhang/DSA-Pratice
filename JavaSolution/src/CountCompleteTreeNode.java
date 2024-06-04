public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursive case
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
    public int countNodesUsingCompleteBT(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // find the depth
        int depth = findTreeDepth(root);
        // intialize two pointers left, right
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;
        // while left <= right
        while (left <= right) {
            int mid = (left + right) / 2;
            // check if mid exist in last level
            boolean isExist = exist(mid, depth, root);
            if (isExist) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // compute #nodes = 2^d - 1 + left
        return (int) Math.pow(2, depth) - 1 + left;
    }
    public int findTreeDepth(TreeNode root) {
        // base case
        if (root == null) {
            return -1;
        }
        // recursive case
        return 1 + findTreeDepth(root.left);
    }
    public boolean exist(int index, int depth, TreeNode root) {
        TreeNode currNode = root;
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;
        int pivot;
        for (int i = 0; i < depth; i++) {
            pivot = (left + right) / 2;
            if (index <= pivot) {
                currNode = currNode.left;
                right = pivot;
            } else {
                currNode = currNode.right;
                left = pivot + 1;
            }
        }
        return currNode != null;
    }
    public static void main(String[] main) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        CountCompleteTreeNode countCompleteTreeNode = new CountCompleteTreeNode();
        System.out.println(countCompleteTreeNode.countNodesUsingCompleteBT(root));

    }
}
