import java.util.*;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // build adjcancy list for the graph
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nextNode = i < n - 1 ? i + 1 : 0;
            List<int[]> currList = adjList.getOrDefault(i, new ArrayList<>());
            currList.add(new int[]{nextNode, cost[i]});
            adjList.put(i, currList);
        }

        // for (i = 0; i < n; i++)
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            if (dfs(i, 0, visited, adjList, gas)) {
                return i;
            }
        }

        // return -1;
        return -1;
    }
    public static boolean dfs(int currNode, int currGas, Set<Integer> visited, Map<Integer, List<int[]>> adjList, int[] gas) {
        // base case
        // if (gas < 0)
        if (currGas < 0) {
            return false;
        }
        // if (prevNode != -1 && i == startNode)
        if (visited.contains(currNode)) {
            return true;
        }
        // currGas = currGas + gas(i)
        visited.add(currNode);
        currGas += gas[currNode];
        // recursive case
        // for (neighbor in neighbors)
        for (int[] neighbor : adjList.get(currNode)) {
            if (dfs(neighbor[0], currGas - neighbor[1], visited, adjList, gas)) {
                return true;
            }
        }
        // return false
        return false;
    }
    public static int canCompleteCircuitOptimal(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int startIndex = 0;
        int currGain = 0;
        int totalGain = 0;
        for (int i = 0; i < n; i++) {
            totalGain += diff[i];
            currGain += diff[i];
            if (currGain < 0) {
                startIndex = i + 1;
                currGain = 0;
            }
        }
        return totalGain >= 0 ? startIndex : -1;
    }
    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
