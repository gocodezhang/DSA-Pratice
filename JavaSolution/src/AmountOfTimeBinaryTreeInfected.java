import java.util.*;

public class AmountOfTimeBinaryTreeInfected {
    public int amountOfTime(TreeNode root, int start) {
        // convert to graph
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(root.val, new ArrayList<>());
        convertToGraph(root.val, root.left, adj);
        convertToGraph(root.val, root.right, adj);
        // perform bfs from the start

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                visited.add(curr);
                List<Integer> adjlist = adj.get(curr);
                for (int j = 0; j < adjlist.size(); j++) {
                    int nextNode = adjlist.get(j);
                    if (!visited.contains(nextNode)) {
                        queue.add(nextNode);
                    }
                }
            }
            step++;
        }

        return step - 1;
    }
    public void convertToGraph(int parent, TreeNode currNode, HashMap<Integer, List<Integer>> adj) {
        if (currNode == null) {
            return;
        }

        if (!adj.containsKey(parent)) {
            adj.put(parent, new ArrayList<>());
        }
        if (!adj.containsKey(currNode.val)) {
            adj.put(currNode.val, new ArrayList<>());
        }
        List<Integer> parentList = adj.get(parent);
        parentList.add(currNode.val);
        List<Integer> childList = adj.get(currNode.val);
        childList.add(parent);

        convertToGraph(currNode.val, currNode.left, adj);
        convertToGraph(currNode.val, currNode.right, adj);
    }
}
