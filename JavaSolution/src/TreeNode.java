import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode currNode = stack.pop();
            resultList.add(currNode.val);
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return resultList;
    }
    public static List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            resultList.add(curr.val);
            curr = curr.right;

        }
        return resultList;
    }
    public static List<Integer> postOrderIterative(TreeNode root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            resultList.addFirst(curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return resultList;
    }
    public static List<Integer> postOrderIterative2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (!stack.empty() && stack.peek() == curr.right ) {
                stack.pop();
                stack.push(curr);
                curr = curr.right;
            } else {
                resultList.add(curr.val);
                curr = null;
            }
        }
        return resultList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        node2.left = node4;
        node2.right = node5;
        root.right = node3;
        node3.left = node6;
        node3.right = node7;
        System.out.println(postOrderIterative2(root));
    }
}
