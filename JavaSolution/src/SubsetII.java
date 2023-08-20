import java.util.*;

public class SubsetII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // create resArr = [];
        List<List<Integer>> resArr = new ArrayList<>();
        // create currSet = [];
        List<Integer> currSet = new ArrayList<Integer>();
        dfs(0, nums, currSet, resArr);

        // return resArr
        return resArr;
    }

    public static void dfs(Integer i, int[] nums, List<Integer> currSet, List<List<Integer>> resArr) {
        if (i >= nums.length) {
            if (!resArr.contains(currSet)) {
                resArr.add(new ArrayList<>(currSet));
            }
            return;
        }
        // when yes,
        // check if currSet exist in resArr
        // if no, add currSet in resArr
        // return

        // recursive case
        // add ith element in currSet
        currSet.add(nums[i]);
        // dfs(i + 1);
        dfs(i + 1, nums, currSet, resArr);
        // pop ith element in currSet
        currSet.remove(currSet.size() - 1);
        // dfs(i + 1)
        dfs(i + 1, nums, currSet, resArr);

    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> resultArr = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            if (counterMap.containsKey(num)) {
                counterMap.put(num, counterMap.get(num) + 1);
            } else {
                counterMap.put(num, 1);
            }
        }
        List<int[]> counterList = new ArrayList<>();
        counterMap.forEach((c, f) -> {
            counterList.add(new int[]{c, f});
        });
        dfs(currSet, resultArr, counterList, 0);

        return resultArr;

    }
    public static void dfs(List<Integer> currSet, List<List<Integer>> resultArr, List<int[]> counter, int index) {
        resultArr.add(new ArrayList<>(currSet));
        for (int i = index; i < counter.size(); i++) {
            int[] currTuple = counter.get(i);
            int candidate = currTuple[0];
            int frequency = currTuple[1];
            if (frequency <= 0) {
                continue;
            }
            currSet.add(candidate);
            counter.set(i, new int[]{candidate, frequency - 1});
            dfs(currSet, resultArr, counter, i);
            currSet.remove(currSet.size() - 1);
            counter.set(i, new int[]{candidate, frequency});

        }

    }

    public static void main(String[] args) {
        int[] nums = {4,1,4};
        // System.out.println(subsetsWithDup(nums));
        System.out.println(subsetsWithDup2(nums));
    }
}
