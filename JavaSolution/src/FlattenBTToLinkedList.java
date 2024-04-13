import java.util.Stack;

public class FlattenBTToLinkedList {
    public void flatten(TreeNode root) {
        // base case
        // if null
        if (root == null) {
            return;
        }

        // recursive case
        // copyRightChild = node.right
        TreeNode copyLeftChild = root.left;
        TreeNode copyRightChild = root.right;
        if (copyRightChild != null) {
            flatten(copyRightChild);
        }
        if (copyLeftChild != null) {
            // node.right = dfs(node.left)
            flatten(copyLeftChild);
            root.right = copyLeftChild;
            // node.left = null
            root.left = null;
            // find the last node in the branch
            while (copyLeftChild.right != null) {
                copyLeftChild = copyLeftChild.right;
            }
            copyLeftChild.right = copyRightChild;
        }
    }
    public void flattenIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        int start = 1;
        int end = 2;
        TreeNode tailNode = null;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, start));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> currPair = stack.pop();
            TreeNode currNode = currPair.getKey();
            Integer currStatus = currPair.getValue();

            if (currNode.left == null && currNode.right == null) {
                tailNode = currNode;
                continue;
            }

            if (currStatus == start) {
                if (currNode.left != null) {
                    stack.push(new Pair<>(currNode, end));
                    stack.push(new Pair<>(currNode.left, start));
                } else if (currNode.right != null) {
                    stack.push(new Pair<>(currNode.right, start));
                }
            } else {
                TreeNode rightBranch = currNode.right;
                if (tailNode != null) {
                    TreeNode leftBranch = currNode.left;
                    currNode.left = null;
                    currNode.right = leftBranch;
                    tailNode.right = rightBranch;
                }
                if (rightBranch != null) {
                    stack.push(new Pair<>(rightBranch, start));
                }
            }
        }
    }
    public static void main(String[] args) {
        FlattenBTToLinkedList flattenBTToLinkedList = new FlattenBTToLinkedList();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        node2.left = node3;
        node2.right = node4;
        root.right = node5;
        flattenBTToLinkedList.flattenIterative(root);
    }

}
