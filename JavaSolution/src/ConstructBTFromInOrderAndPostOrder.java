import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInOrderAndPostOrder {
    static int[] inorderArr;
    static int[] postorderArr;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // find the root from the post-order
        // build the root
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        // update in-order & post-order
        // find the left element & right element to the root
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        //leftPostOrder = 0 -> rightIndex
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        //RightPostOrder = rightIndex -> currLengthOfPostOrder - 1
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, postorder.length - 1 - rightInOrder.length, postorder.length - 1);
        // root.left = buildTree(leftInOrder, leftPostOrder)
        root.left = buildTree(leftInOrder, leftPostOrder);
        // root.right = buildTree(RightInOrder, RightPostOrder)
        root.right = buildTree(rightInOrder, rightPostOrder);

        // return root
        return root;
    }
    public static TreeNode buildTreeOptimal(int[] inorder, int[] postorder) {
        inorderArr = inorder;
        postorderArr = postorder;
        // build hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length, 0, postorder.length, map);
    }
    public static TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        int rootValue = postorderArr[postEnd - 1];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - (rootIndex + 1);

        root.left = helper(inStart, rootIndex, postStart, postStart + leftSize, map);
        root.right = helper(rootIndex + 1, inEnd, postEnd - 1 - rightSize, postEnd - 1, map);
        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {2,3,1};
        int[] postorder = {3,2,1};
        buildTreeOptimal(inorder, postorder);
    }
}
