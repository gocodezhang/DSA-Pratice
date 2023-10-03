import java.util.*;

public class AllNodesDistanceKInBT {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Convert the tree into a graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        buildGraph(root, adjList);
        // Start from target node in the graph and find all nodes
        int targetVal = target.val;
        List<Integer> resultList = new ArrayList<>();
        dfs(targetVal, -1, k, resultList, adjList);

        return resultList;
    }
    public static List<Integer> distanceKBFS(TreeNode root, TreeNode target, int k) {
        // Convert the tree into a graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        buildGraph(root, adjList);
        // Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i++) {
                    resultList.add(queue.poll());
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();
                visited.add(currNode);
                List<Integer> neighbors = adjList.getOrDefault(currNode, new ArrayList<>());
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
            k--;
        }
        return resultList;
    }
    public static void dfs(int currNode, int prevNode, int distance, List<Integer> resultList, Map<Integer, List<Integer>> adjList) {
        if (distance == 0) {
            resultList.add(currNode);
            return;
        }
        List<Integer> neighbors = adjList.getOrDefault(currNode, new ArrayList<>());
        for (Integer neighbor : neighbors) {
            if (neighbor == prevNode) {
                continue;
            }
            dfs(neighbor, currNode, distance - 1, resultList, adjList);
        }
    }
    public static void buildGraph(TreeNode currNode, Map<Integer, List<Integer>> adjList) {
        if (currNode.left == null && currNode.right == null) {
            return;
        }

        if (currNode.left != null) {
            TreeNode leftChild = currNode.left;

            List<Integer> currList = adjList.getOrDefault(currNode.val, new ArrayList<>());
            currList.add(leftChild.val);
            adjList.put(currNode.val, currList);

            List<Integer> leftList = adjList.getOrDefault(leftChild.val, new ArrayList<>());
            leftList.add(currNode.val);
            adjList.put(leftChild.val, leftList);

            buildGraph(leftChild, adjList);
        }

        if (currNode.right != null) {
            TreeNode rightChild = currNode.right;

            List<Integer> currList = adjList.getOrDefault(currNode.val, new ArrayList<>());
            currList.add(rightChild.val);
            adjList.put(currNode.val, currList);

            List<Integer> leftList = adjList.getOrDefault(rightChild.val, new ArrayList<>());
            leftList.add(currNode.val);
            adjList.put(rightChild.val, leftList);

            buildGraph(rightChild, adjList);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        System.out.println(distanceKBFS(root, root, 1));
    }
}
