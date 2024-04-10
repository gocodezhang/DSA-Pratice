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
        flattenBTToLinkedList.flatten(root);
    }

}
