import java.util.*;

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] currEdge = edges[i];

            Set<Integer> visited = new HashSet<>();
            if (dfs(graph, visited, currEdge[0], currEdge[1])) {
                return currEdge;
            }
            if (!graph.containsKey(currEdge[0])) {
                graph.put(currEdge[0], new ArrayList<>());
            }
            if (!graph.containsKey(currEdge[1])) {
                graph.put(currEdge[1], new ArrayList<>());
            }
            graph.get(currEdge[0]).add(currEdge[1]);
            graph.get(currEdge[1]).add(currEdge[0]);
        }
        return new int[]{};
    }
    public static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, Integer source, Integer target) {
        if (source.equals(target)) {
            return true;
        }
        visited.add(source);
        List<Integer> neighbors = graph.getOrDefault(source, new ArrayList<>());
        for (Integer neighbor : neighbors) {
            if (!visited.contains(neighbor) && dfs(graph, visited, neighbor, target)) {
                return true;
            }
        }
        return false;
    }
    public static int[] findRedundantConnection2(int[][] edges) {
        DisjointSet dsu = new DisjointSet(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int[] currEdge = edges[i];
            if (dsu.isConnect(currEdge[0], currEdge[1])) {
                return currEdge;
            }
            dsu.connect(currEdge[0], currEdge[1]);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[][] edges = {
                {1, 4},
                {3, 4},
                {1, 3},
                {1, 2},
                {4, 5}
        };
        System.out.println(Arrays.toString(findRedundantConnection2(edges)));
    }
}
