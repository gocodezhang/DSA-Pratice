import java.util.ArrayList;

public class MinAbsDiffInBST {
    ArrayList<Integer> bstArr = new ArrayList<>();
    TreeNode prevNode;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int globalMin = Integer.MAX_VALUE;
        for (int i = 1; i < bstArr.size(); i++) {
            int absDiff = Math.abs(bstArr.get(i - 1) - bstArr.get(i));
            globalMin = Math.min(globalMin, absDiff);
        }
        return globalMin;
    }
    public void dfs(TreeNode currNode) {
        // base case
        if (currNode == null) {
            return;
        }
        dfs(currNode.left);
        bstArr.add(currNode.val);
        dfs(currNode.right);
    }
    public int getMinimumDifferenceWithoutList(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }
    public void inOrderTraversal(TreeNode currNode) {
        if (currNode == null) {
            return;
        }
        inOrderTraversal(currNode.left);
        if (prevNode != null) {
            int diff = Math.abs(currNode.val - prevNode.val);
            minDiff = Math.min(minDiff, diff);
        }
        prevNode = currNode;
        inOrderTraversal(currNode.right);
    }
    public static void main(String[] args) {
        MinAbsDiffInBST minAbsDiffInBST = new MinAbsDiffInBST();
        TreeNode root = new TreeNode(236);
        TreeNode node104 = new TreeNode(104);
        TreeNode node701 = new TreeNode(701);
        TreeNode node227 = new TreeNode(227);
        root.left = node104;
        root.right = node701;
        node104.right = node227;
        System.out.println(minAbsDiffInBST.getMinimumDifference(root));
    }
}
