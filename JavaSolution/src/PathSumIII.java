import java.util.HashMap;

public class PathSumIII {
    int result;
    HashMap<Long, Integer> prefixSumMap;
    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        prefixSumMap = new HashMap<>();
        prefixSumMap.put((long) 0, 1);
        dfs(root, 0, targetSum);

        return result;
    }
    public void dfs(TreeNode root, long prefixSum, int targetSum) {
        if (root == null) {
            return;
        }

        long currSum = prefixSum + root.val;

        if (prefixSumMap.containsKey(currSum - targetSum)) {
            result += prefixSumMap.get(currSum - targetSum);
        }
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

        dfs(root.left, currSum, targetSum);
        dfs(root.right, currSum, targetSum);

        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);
    }
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node10.left = node5;
        node5.left = node3;
        node5.right = node2;
        node2.right = node1;
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(node10, 8));

    }
}
