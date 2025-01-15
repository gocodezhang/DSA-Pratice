import java.util.*;

public class SumOfImbalanceNumOfAllArrs {
    public int sumImbalanceNumbersBF(int[] nums) {
        int result = 0;
        // create all subarrays
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new LinkedList<>();
            for (int j = i; j < nums.length; j++) {
                insertIntoSortList(temp, nums[j]);
                result += computeImbalance(temp);
            }
        }

        return result;
    }
    public int computeImbalance(List<Integer> list) {
        if (list.size() <= 1) {
            return 0;
        }
//        // sort the list
//        Collections.sort(list);

        // compute imbalance
        int imbalance = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) > 1) {
                imbalance++;
            }
        }
        return imbalance;
    }
    public void insertIntoSortList(List<Integer> sortedList, int num) {
        if (sortedList.size() == 0) {
            sortedList.add(num);
            return;
        }

        // perform binary search
        int left = 0;
        int right = sortedList.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (sortedList.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        sortedList.add(left, num);
    }
    public int sumImbalanceNumbersOptimized(int[] nums) {
        int result = 0;
        // create all subarrays
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new LinkedList<>();
            int imbalance = 0;
            for (int j = i; j < nums.length; j++) {
                int updated = insertAndCompute(temp, nums[j], imbalance);
                result += updated;
                imbalance = updated;
            }
        }

        return result;
    }
    public int insertAndCompute(List<Integer> sortedList, int num, int prevImbalance) {

        if (sortedList.size() == 0) {
            sortedList.add(num);
            return 0;
        }

        // perform binary search
        int left = 0;
        int right = sortedList.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (sortedList.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        sortedList.add(left, num);

        if (sortedList.size() == 1) {
            return 0;
        }
        // insert in middle, start or end
        if (left == 0) {
            if (sortedList.get(left) < sortedList.get(left + 1) - 1) {
                prevImbalance++;
            }
            return prevImbalance;
        } else if (left == sortedList.size() - 1) {
            if (sortedList.get(left - 1) < sortedList.get(left) - 1) {
                prevImbalance++;
            }
            return prevImbalance;
        } else {
            if (sortedList.get(left) < sortedList.get(left + 1) - 1) {
                prevImbalance++;
            }
            if (sortedList.get(left) - sortedList.get(left - 1) == 1 && sortedList.get(left) < sortedList.get(left + 1)) {
                prevImbalance--;
            }
            return prevImbalance;
        }
    }
    public int sumImbalanceNumbersSet(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(nums[i]);
            int curr = 0;

            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[j];
                if (!set.contains(num)) {
                    int increase = 1;
                    if (set.contains(num - 1)) {
                        increase--;
                    }
                    if (set.contains(num + 1)) {
                        increase--;
                    }
                    curr += increase;
                    set.add(num);
                }
                result += curr;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1,1,1};
        SumOfImbalanceNumOfAllArrs sumOfImbalanceNumOfAllArrs = new SumOfImbalanceNumOfAllArrs();
        System.out.println(sumOfImbalanceNumOfAllArrs.sumImbalanceNumbersOptimized(nums));
    }
}
