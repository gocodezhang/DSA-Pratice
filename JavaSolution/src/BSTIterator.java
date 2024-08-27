import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        travelToLeftMost(root);
    }

    public int next() {
        TreeNode currNode = stack.pop();
        if (currNode.right != null) {
            travelToLeftMost(currNode.right);
        }
        return currNode.val;

    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void travelToLeftMost(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        travelToLeftMost(root.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.left = node3;
        root.right = node15;
        node15.left = node9;
        node15.right = node20;
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

}
