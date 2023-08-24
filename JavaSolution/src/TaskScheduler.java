import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        // create minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // create frequencyMap
        Map<String, Integer> prevMap = new HashMap<>();
        // iterate through tasks
        for (int i = 0; i < tasks.length; i++) {
            // curr Str
            String currStr = "" + tasks[i];
            // if frequencyMap.containsKey(currStr)
            if (prevMap.containsKey(currStr)) {
                // frequencyMap.put(currStr, frequencyMap.get(currStr) + 1 + gap)
                int updatedTime = prevMap.get(currStr) + 1 + n;
                prevMap.put(currStr, updatedTime);
                minHeap.add(updatedTime);
            } else {
                // if no, push 0 into minHeap
                minHeap.add(0);
                // frequencyMap.put(currStr, 0);
                prevMap.put(currStr, 0);
            }

        }
        // currTime = 0;
        int currTime = 0;
        // while (minHeap.size() != 0)
        while (minHeap.size() != 0) {
            // check if minHeap.peek() <= currTime
            if (minHeap.peek() <= currTime) {
                // if yes, minHeap.poll();
                minHeap.poll();
            }
            // increase currTime
            currTime++;
        }

        // return currTime;
        return currTime;
    }
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
}
