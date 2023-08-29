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
    public static void main(String[] args) {
        int numsCourse = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        System.out.println(Arrays.toString(findOrder(numsCourse, prerequisites)));
    }
}
