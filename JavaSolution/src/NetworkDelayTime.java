import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            List<Pair> list1 = graph.getOrDefault(time[0], new ArrayList<>());
            list1.add(new Pair(time[1], time[2]));
            graph.put(time[0], list1);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        dfs(k, graph, distance, 0);

        int delayTime = -1;
        for (int index = 1; index < distance.length; index++) {
            if (distance[index] > delayTime) {
                delayTime = distance[index];
            }
        }

        return delayTime == Integer.MAX_VALUE ? -1 : delayTime;

    }
    public static void dfs(int currNode, Map<Integer, List<Pair>> graph, int[] distance, int currDist) {
        if (distance[currNode] < currDist) {
            return;
        }
        distance[currNode] = currDist;
        List<Pair> neighbors = graph.getOrDefault(currNode, new ArrayList<>());
        for (Pair neighbor : neighbors) {
            dfs(neighbor.node, graph, distance, currDist + neighbor.dist);
        }
    }
    public static int networkDelayTimeBFS(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            List<Pair> list = graph.getOrDefault(time[0], new ArrayList<>());
            list.add(new Pair(time[1], time[2]));
            graph.put(time[0], list);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        distance[k] = 0;
        queue.add(k);

        while (queue.size() > 0) {
            Integer node = queue.poll();
            List<Pair> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (Pair neighbor : neighbors) {
                if (distance[neighbor.node] > distance[node] + neighbor.dist) {
                    distance[neighbor.node] = distance[node] + neighbor.dist;
                    queue.add(neighbor.node);
                }
            }
        }

        int delayTime = -1;
        for (int index = 1; index < distance.length; index++) {
            if (distance[index] > delayTime) {
                delayTime = distance[index];
            }
        }

        return delayTime == Integer.MAX_VALUE ? -1 : delayTime;

    }
    static class Pair {
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(networkDelayTimeBFS(times, 4, 2));
    }
}
