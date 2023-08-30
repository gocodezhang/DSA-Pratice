import java.util.*;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // create a graph
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // iterate through prereqs
        for (int[] currPreReq : prerequisites) {
            // currPreReq
            // graph.put(currPreReq[1], graph.get(currPreReq[1]).add(currPreReq[0]))
            List<Integer> list = graph.getOrDefault(currPreReq[1], new ArrayList<>());
            list.add(currPreReq[0]);
            graph.put(currPreReq[1], list);
            inDegree[currPreReq[0]]++;
        }

        // create a queue
        Queue<Integer> queue = new LinkedList<>();
        // iterate through inDegree
        for (int index = 0; index < inDegree.length; index++) {
            if (inDegree[index] == 0) {
                queue.add(index);
            }
        }
        int courseIndex = 0;
        // while queue is not empty
        while (queue.size() > 0) {
            // currCourse = queue.poll();
            Integer currCourse = queue.poll();
            // add currCourse into resList
            order[courseIndex] = currCourse;
            courseIndex++;
            // for preReq contains currCourse, remove it
            if (graph.containsKey(currCourse)) {
                for (Integer nextCourse : graph.get(currCourse)) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.add(nextCourse);
                    }
                }
            }
        }

        // resList.length == n
        if (courseIndex == numCourses) {
            return order;
        } else {
            return new int[]{};
        }
    }
    public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] visited = new int[numCourses];
        List<Integer> resultList = new ArrayList<>();

        for (int[] prepReq : prerequisites) {
            List<Integer> list = graph.getOrDefault(prepReq[1], new ArrayList<>());
            list.add(prepReq[0]);
            graph.put(prepReq[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if(!dfs(i, graph, visited, resultList)) {
                    return new int[]{};
                }
            }
        }

        int[] resultArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            resultArr[i] = resultList.get(numCourses - 1 - i);
        }
        return resultArr;

    }
    public static boolean dfs(Integer currNode, Map<Integer, List<Integer>> graph, int[] visited, List<Integer> resultList) {
        visited[currNode] = 1;
        List<Integer> neighbors = graph.getOrDefault(currNode, new ArrayList<>());
        for (Integer neighbor : neighbors) {
            if (visited[neighbor] == 1) {
                return false;
            } else if (visited[neighbor] == 0 && !dfs(neighbor, graph, visited, resultList)) {
                return false;
            }
        }
        visited[currNode] = 2;
        resultList.add(currNode);
        return true;
    }
    public static void main(String[] args) {
        int numsCourse = 3;
        int[][] prerequisites = {
                {0, 2},
                {1, 2},
                {2, 0}
        };
        System.out.println(Arrays.toString(findOrderDFS(numsCourse, prerequisites)));
    }
}
