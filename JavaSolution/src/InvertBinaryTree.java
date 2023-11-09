public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        // when root == null
        if (root == null) {
            return null;
        }

        // create invertedRoot = new TreeNode(root.val)
        TreeNode invertedRoot = new TreeNode(root.val);
        // invertedRoot.left = invertTree(root.right)
        invertedRoot.left = invertTree(root.right);
        // invertedRoot.right = invertTree(root.left)
        invertedRoot.right = invertTree(root.left);

        // return invertedRoot
        return invertedRoot;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(invertTree(root));
    }
}
