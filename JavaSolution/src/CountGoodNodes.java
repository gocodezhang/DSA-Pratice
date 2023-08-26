import java.util.Stack;

public class CountGoodNodes {
    static int numOfGoodNotes = 0;
    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numOfGoodNotes;
    }
    public static void dfs(TreeNode node, int maxNum) {
        // base case
        // if node == null
        if (node == null) {
            return;
        }
        // check if node.val >= max
        if (node.val >= maxNum) {
            // increment goodNodes
            numOfGoodNotes++;
            // max = node.val
            maxNum = node.val;
        }
        // dfs(node.left, max)
        dfs(node.left, maxNum);
        // dfs(node.right, max)
        dfs(node.right, maxNum);
    }
    public static int goodNodes2(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        while (!stack.empty()) {
            Pair currPair = stack.pop();
            TreeNode currNode = currPair.node;
            if (currNode.val >= currPair.maxSoFar) {
                result++;
            }
            if (currNode.left != null) {
                stack.push(new Pair(currNode.left, Math.max(currNode.val, currPair.maxSoFar)));
            }
            if (currNode.right != null) {
                stack.push(new Pair(currNode.right, Math.max(currNode.val, currPair.maxSoFar)));
            }
        }
        return result;
    }
    static class Pair {
        TreeNode node;
        int maxSoFar;
        public Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node11 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node21 = new TreeNode(1);
        TreeNode node25 = new TreeNode(5);
        root.left = node11;
        node11.left = node23;
        root.right = node14;
        node14.left = node21;
        node14.right = node25;
        System.out.println(goodNodes2(root));
    }
}
