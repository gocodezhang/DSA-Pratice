import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        // add the root
        resultList.add(root.val);
        // add the left boundary
        leftBoundary(root.left, resultList);
        // add leafs
        if (root.left != null || root.right != null) {
            leafs(root, resultList);
        }
        // add the right boundary
        rightBoundary(root.right, resultList);
        return resultList;
    }
    public static void leftBoundary(TreeNode currNode, List<Integer> resultList) {
        // base case
        // if currNode == null
        if (currNode == null) {
            return;
        }
        // if currNode.left == null && currNode.right ==null
        if (currNode.left == null && currNode.right == null) {
            return;
        }
        // rescursive case
        // add currNode into resultArr
        resultList.add(currNode.val);
        // if currNode.left != null
        if (currNode.left != null) {
            leftBoundary(currNode.left, resultList);
        } else {
            leftBoundary(currNode.right, resultList);
        }
    }
    public static void rightBoundary(TreeNode currNode, List<Integer> resultList) {
        if (currNode == null) {
            return;
        }
        // if currNode.left == null && currNode.right ==null
        if (currNode.left == null && currNode.right == null) {
            return;
        }
        // rescursive case
        // if currNode.left != null
        if (currNode.right != null) {
            rightBoundary(currNode.right, resultList);
        } else {
            rightBoundary(currNode.left, resultList);
        }
        resultList.add(currNode.val);
    }
    public static void leafs(TreeNode currNode, List<Integer> resultList) {
        // base case
        // if currNode == null
        if (currNode == null) {
            return;
        }
        // if currNode.left == null && currNode.right ==null
        if (currNode.left == null && currNode.right == null) {
            resultList.add(currNode.val);
            return;
        }
        // recursive case
        // leafs(left)
        leafs(currNode.left, resultList);
        // leads(right)
        leafs(currNode.right, resultList);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node10 = new TreeNode(10);
        root.right = rightTree;
        rightTree.left = node3; node3.right = node2; node2.right = node5;
        System.out.println(boundaryOfBinaryTree(root));
    }
}
