public class SumRootToLeaf {
    public static int sumNumbers(TreeNode root) {

        return dfs(root, "", 0);
    }
    public static int dfs(TreeNode currNode, String currStr, int result) {
        // if currNode is null
        if (currNode.left == null && currNode.right == null) {
            // const currSum = Integer.parseint(currString)
            int currSum = Integer.parseInt(currStr + currNode.val);
            // return sum + currSum
            return result + currSum;
        }
        // dfs(currNode.left, currString + currNode.val, sum) +
        // dfs(currNode.right, currString + currNode.val, sum)
        int sum = 0;
        if (currNode.left != null) {
            sum += dfs(currNode.left, currStr + currNode.val, result);
        }
        if (currNode.right != null) {
            sum += dfs(currNode.right, currStr + currNode.val, result);
        }
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        System.out.println(sumNumbers(root));
    }
}
