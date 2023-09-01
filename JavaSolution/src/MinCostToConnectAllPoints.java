import java.util.*;

public class MinCostToConnectAllPoints {
    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
        Set<String> mst = new HashSet<>();
        pq.add(new Pair(points[0], 0));
        int distance = 0;

        while (mst.size() < points.length) {
            Pair currPair = pq.poll();
            int[] currPoint = currPair.point;
            int dist = currPair.dist;
            if (mst.contains(currPoint[0] + "-" + currPoint[1])) {
                continue;
            }
            mst.add(currPoint[0] + "-" + currPoint[1]);
            distance += dist;
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                if (!mst.contains(point[0] + "-" + point[1])) {
                    int updatedDistance = Math.abs(currPoint[0] - point[0]) + Math.abs(currPoint[1] - point[1]);
                    pq.add(new Pair(point, updatedDistance));
                }
            }

        }
        return distance;
    }
    public static int minCostConnectPointsKruskal(int[][] points) {
        int n = points.length;
        DisjoinSet dsu = new DisjoinSet(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        // create all edges [node1, node2, distance]
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int distance = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                pq.add(new int[]{i, j, distance});
            }
        }
        int edges = 0;
        int distance = 0;
        // while number edges in MST < n
        while (edges < n - 1) {
            int[] edge = pq.poll();
            // check if two node connected
            if (!dsu.isConnect(edge[0], edge[1])) {
                // if no, add the edge
                dsu.connect(edge[0], edge[1]);
                edges++;
                distance += edge[2];
            }
        }
        return distance;
    }
    static class Pair {
        int[] point;
        int dist;
        public Pair(int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        System.out.println(minCostConnectPointsKruskal(points));
    }
}
