import java.util.*;

public class BinaryTreeRSV {
    public static List<Integer> rightSideView(TreeNode root) {
        // create list
        List<Integer> resultList = new ArrayList<>();
        // levelOrderTraversal
        levelOrderTraversal(root, resultList);
        // return list
        return resultList;
    }
    public static void levelOrderTraversal(TreeNode root, List<Integer> list) {
        // check if node is null
        if (root == null) {
            return;
        }
        // create a queue
        Queue<TreeNode> queue = new LinkedList<>();
        // add (node, 0) in the queue
        queue.add(root);
        // while (stack is not empty)
        while (queue.size() != 0) {
            // pop queue
            int currLevelLength = queue.size();
            for (int i = 0; i < currLevelLength; i++) {
                TreeNode node = queue.poll();
                if (i == currLevelLength - 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        levelOrderRecursion(root, 0, resultList);
        return resultList;
    }
    public static void levelOrderRecursion(TreeNode node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node.val);
        }
        levelOrderRecursion(node.right, level + 1, list);
        levelOrderRecursion(node.left, level + 1, list);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node2.right = node5;
        node5.right = node6;
        System.out.println(rightSideView2(root));
    }
}
