import java.util.Arrays;

public class DisjoinSet {
    int[] parent;
    int[] size;
    // Constructor
    public DisjoinSet(int num) {
        parent = new int[num + 1];
        size = new int[num + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
    }
    // Method: find the parent of it given a node
    public int findParent(int node) {
        if (parent[node] == -1) {
            return node;
        }
        return findParent(parent[node]);
    }
    // Method: connect two nodes together
    public void connect(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        if (size[parent1] >= size[parent2]) {
            parent[parent2] = parent1;
            size[parent1] = size[parent1] + size[parent2];
        } else {
            parent[parent1] = parent2;
            size[parent2] = size[parent2] + size[parent1];
        }
    }
    // Method: check if two nodes are connected
    public boolean isConnect(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        return parent1 == parent2;
    }
    public static void main(String[] args) {
        DisjoinSet dsu = new DisjoinSet(6);
        int[][] edges = {
                {1, 2},
                {2, 3},
                {4, 5},
                {5, 6},
                {2, 6}
        };
        for (int i = 0; i < edges.length; i++) {
            int[] currEdge = edges[i];
            dsu.connect(currEdge[0], currEdge[1]);
        }
        System.out.println(Arrays.toString(dsu.parent));
    }
}
