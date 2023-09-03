import java.util.*;

public class CheapestFlightsWithinK {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create graph (map)
        Map<Integer, List<Pair>> graph = new HashMap<>();
        // Iterate through flights
        for (int i = 0; i < flights.length; i++) {
            // currflight
            int[] currFlight = flights[i];
            // get list for currflight[0]
            List<Pair> list = graph.getOrDefault(currFlight[0], new ArrayList<>());
            // add currflight[1] into the list
            list.add(new Pair(currFlight[1], currFlight[2]));
            graph.put(currFlight[0], list);
        }
        Pair miniPrice = new Pair(dst, Integer.MAX_VALUE);
        // dfs
        int[] visited = new int[n];
        dfs(graph, src, miniPrice, k, visited, 0);
        // return miniPrice
        if (miniPrice.weight == Integer.MAX_VALUE) {
            return -1;
        }
        return miniPrice.weight;
    }
    public static void dfs(Map<Integer, List<Pair>> graph, int currNode, Pair miniPrice, int remainStop, int[] visited, int price) {
        // base case
        visited[currNode] = 1;
        // remainingStop == 0 && currNode != target
        if (remainStop <= -1 && currNode != miniPrice.node) {
            return;
        }
        // currNode == target
        if (currNode == miniPrice.node) {
            // if (price < miniPrice)
            if (price < miniPrice.weight) {
                // miniPrice = price
                miniPrice.weight = price;
            }
            return;
        }
        // find neighbors from graph
        List<Pair> neighbors = graph.getOrDefault(currNode, new ArrayList<>());
        // iterate over neighbors
        for (Pair neighbor : neighbors) {
            //dfs(graph, neighbor, target, remainingStop - 1, price + neighbor.price
            if (visited[neighbor.node] == 1) {
                continue;
            }
            dfs(graph, neighbor.node, miniPrice, remainStop - 1, visited, price + neighbor.weight);
            visited[neighbor.node] = 0;
        }
    }
    public static int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();
            // Iterate on current level.
            while (sz-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node))
                    continue;
                // Loop over neighbors of popped node.
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour])
                        continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] { neighbour, dist[neighbour] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    static class Pair {
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 5},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(findCheapestPriceBFS(5, flights, 0, 4, 2));
    }
}
