import java.util.Arrays;
import java.util.HashMap;

public class ConstructBTFromPreOrderAndInOrder {
    private HashMap<Integer, Integer> indexMap;
    private int[] preorder;
    private int[] inorder;
    private int currPointer;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currPointer = 0;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;

        return buildTreeHelper(0, inorder.length - 1);
    }
    public TreeNode buildTreeHelper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int nodeValue = preorder[currPointer];
        currPointer++;
        TreeNode node = new TreeNode(nodeValue);
        int index = indexMap.get(nodeValue);
        node.left = buildTreeHelper(inLeft, index - 1);
        node.right = buildTreeHelper(index + 1, inRight);

        return node;
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBTFromPreOrderAndInOrder constructBTFromPreOrderAndInOrder = new ConstructBTFromPreOrderAndInOrder();
        TreeNode root = constructBTFromPreOrderAndInOrder.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
