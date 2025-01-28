import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // count
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        // go through isConnected
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, visited, isConnected);
            }
        }


        // return count
        return count;
    }
    public void dfs(int city, HashSet<Integer> visited, int[][] isConnected) {
        if (visited.contains(city)) {
            return;
        }

        visited.add(city);

        int[] connected = isConnected[city];

        for (int j = 0; j < connected.length; j++) {
            if (!visited.contains(j) && connected[j] == 1) {
                dfs(j, visited, isConnected);
            }
        }

    }
    public int findCircleNumBFS(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();

        for (int city = 0; city < n; city++) {
            if (!visited.contains(city)) {
                count++;
                bfs(city, visited, isConnected);
            }
        }

        return count;
    }
    public void bfs(int city, HashSet<Integer> visited, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);

        while (!queue.isEmpty()) {
            int c = queue.poll();
            visited.add(c);

            int[] connect = isConnected[c];
            for (int j = 0; j < connect.length; j++) {
                if (!visited.contains(j) && connect[j] == 1) {
                    queue.add(j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        NumberOfProvinces np = new NumberOfProvinces();
        System.out.println(np.findCircleNumBFS(isConnected));
    }
}
