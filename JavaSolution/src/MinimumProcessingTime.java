import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        // sort tasks
        List<Integer> mutableTasks = new ArrayList<>(tasks);
        List<Integer> mutableProcessorTime = new ArrayList<>(processorTime);
        Collections.sort(mutableTasks, (a, b) -> b - a);
        Collections.sort(mutableProcessorTime);

        int result = 0;
        // go through every processor
        for (int i = 0; i < mutableProcessorTime.size(); i++) {
            // find end time to complete 4 tasks
            int startTime = mutableProcessorTime.get(i);
            for (int j = i * 4; j < (i + 1) * 4; j++) {
                result = Math.max(result, startTime + mutableTasks.get(j));
            }
        }

        // return latest time a processor is completed with 4 tasks
        return result;
    }
    public static void main(String[] args) {
        List<Integer> processorTime = List.of(121,99);
        List<Integer> tasks = List.of(287,315,293,260,333,362,69,233);
        MinimumProcessingTime minimumProcessingTime = new MinimumProcessingTime();
        System.out.println(minimumProcessingTime.minProcessingTime(processorTime, tasks));
    }


}
