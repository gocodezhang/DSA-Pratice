import java.util.*;

public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int level = result.size();
            List<Integer> list = new ArrayList<>();

            boolean fromLeft = level % 2 == 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                list.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            if (!fromLeft) {
                Collections.reverse(list);
            }

            result.add(list);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        BinaryTreeZigZag binaryTreeZigZag = new BinaryTreeZigZag();
        System.out.println(binaryTreeZigZag.zigzagLevelOrder(root));
    }

}
