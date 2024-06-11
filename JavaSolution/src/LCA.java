import java.util.*;

public class LCA {
    TreeNode lca = null;
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return lca;
    }
    public TreeNode findLCAIterative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode currNode = queue.poll();
            if (currNode.left != null) {
                queue.add(currNode.left);
                parentMap.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                parentMap.put(currNode.right, currNode);
            }
        }

        Set<TreeNode> pathP = new HashSet<>();
        TreeNode currNode = p;
        while (currNode != null) {
            pathP.add(currNode);
            currNode = parentMap.getOrDefault(currNode, null);
        }
        TreeNode lca = q;
        while (!pathP.contains(lca)) {
            lca = parentMap.getOrDefault(lca, null);
        }
        return lca;
    }
    public boolean dfs(TreeNode root, TreeNode targetNode1, TreeNode targetNode2) {
        // base case
        if (root == null) {
            return false;
        }

        // recursive case
        int left = dfs(root.left, targetNode1, targetNode2) ? 1 : 0;
        int right = dfs(root.right, targetNode1, targetNode2) ? 1 : 0;

        int self = (root == targetNode1 | root == targetNode2) ? 1 : 0;

        if ((left + right + self) >= 2) {
            lca = root;
        }

        return (left + right + self) > 0;
    }
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node5.left = node6;
        node5.right = node2;
        node3.right = node1;
        node1.left = node0;
        node1.right = node8;
        LCA lca = new LCA();
        System.out.println(lca.findLCA(node3, node6, node2));
        System.out.println(lca.findLCAIterative(node3, node6, node2));
    }
}
