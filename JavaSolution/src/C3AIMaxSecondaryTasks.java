import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * In managing tasks at analytics platform, the goal is to efficiently schedule both primary and secondary tasks within spected time constraints.
 * There are a primary tasks and in secondary tasks. Two arrays, primary and secondary, provide information on task hours,
 * where primary[i] represents the duration in hours of the th primary task, and secondary[i] represents the duration in hours of the fh secondary task.
 *
 * Each day on the platform has a time limit denoted as limit hours. One primary task must be scheduled each day.
 * If time remains after the primary task, you can choose to schedule at most one secondary task on that day.
 * It's essential to ensure that the total hours does not exceed the specified limit hours.
 * Determine te maximum number of secondary tasks that can be scheduled during these n days while adhering to the given constraints.
 *
 * Example:
 * limit = 7
 * primary = [4, 5, 2, 4]
 * secondary = (5, 6, 3, 4].
 */
public class C3AIMaxSecondaryTasks {
    public int findMaximumTasks(int limit, int[] primary, int[] secondary) {
        // sort secondary task
        Arrays.sort(secondary);
        List<Integer> secondaryList = new LinkedList<>();
        for (int num : secondary) {
            secondaryList.add(num);
        }
        // go through primary
        int count = 0;
        for (int i = 0; i < primary.length; i++) {
            // remaining time
            int target = limit - primary[i];
            // perform binary search to find largest secondary time to complete
            if (secondaryList.size() > 0 && binarySearch(secondaryList, target)) {
                count++;
            }
        }
        return count;
    }
    public boolean binarySearch(List<Integer> secondaryList, int target) {
        int left = 0;
        int right = secondaryList.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (secondaryList.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (secondaryList.get(left) <= target) {
            secondaryList.remove(left);
            return true;
        } else if (left -1 >= 0 && secondaryList.get(left - 1) <= target) {
            secondaryList.remove(left - 1);
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args) {
        int limit = 7;
        int[]primary = {4, 5, 2, 4};
        int[] secondary = {};
        C3AIMaxSecondaryTasks c3AIMaxSecondaryTasks = new C3AIMaxSecondaryTasks();
        System.out.println(c3AIMaxSecondaryTasks.findMaximumTasks(limit, primary, secondary));
    }
}
