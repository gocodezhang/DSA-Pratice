import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgLevelInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add((double) sum / levelSize);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        AvgLevelInBinaryTree avgLevelInBinaryTree = new AvgLevelInBinaryTree();
        System.out.println(avgLevelInBinaryTree.averageOfLevels(root));
    }
}
