import java.util.HashMap;
import java.util.HashSet;

/**
 * Amazon OA Question 2:
 *  We are given an array cost with cost of different items. A package can contain at most two items.
 *  The cost of the package is equal to the sum of the item(s) it contains.
 *  For any given distribution, an item can only be in one package (i.e, when distributing items in different packages, an item can only be in one package).
 *  What is the maximum number of packages that can be produced for a given cost array, such that all the packages have the same cost.
 *  (Remember the constraint that a package must have at least one, and at most two items). .
 */
public class AmazonOnlineMK {
    public int findMaximumPackages(int[] cost) {
        // create a map to distinct sum and their frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        // count distinct sum with only one item
        for (int i = 0; i < cost.length; i++) {
            int currCost = cost[i];
            int currFrequency = map.getOrDefault(currCost, 0);
            map.put(currCost, currFrequency + 1);
        }

        // build an array for distinct value
        int[] distCost = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            distCost[index] = key;
            index++;
        }

        // count distinct sum for two item case
        HashMap<Integer, Integer> twoItemMap = new HashMap<>();
        for (int i = 0; i < distCost.length; i++) {
            for (int j = i; j < distCost.length; j++) {
                int sum = distCost[i] + distCost[j];
                int currFrequency = twoItemMap.getOrDefault(sum, 0);
                int increase = i == j ? map.get(distCost[i]) / 2 : Math.min(map.get(distCost[i]), map.get(distCost[j]));
                twoItemMap.put(sum, currFrequency + increase);
            }
        }

        // combine one item and two item
        for (int key : map.keySet()) {
            int fre = twoItemMap.getOrDefault(key, 0);
            int inc = map.get(key);
            twoItemMap.put(key, fre + inc);
        }
        // find maxFrequency
        int result = 0;
        for (int key : twoItemMap.keySet()) {
            result = Math.max(twoItemMap.get(key), result);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] cost1 = {2, 1, 3}; // 2

        int[] cost2 = {4, 5, 10, 3, 1, 2, 2, 2, 3}; // 4

        int[] cost3 = {1, 1, 2, 2, 1, 4}; // 3

        int[] cost4 = {10,2,1}; // 1

        AmazonOnlineMK amazonOnlineMK = new AmazonOnlineMK();
        System.out.println(amazonOnlineMK.findMaximumPackages(cost1));
        System.out.println(amazonOnlineMK.findMaximumPackages(cost2));
        System.out.println(amazonOnlineMK.findMaximumPackages(cost3));
        System.out.println(amazonOnlineMK.findMaximumPackages(cost4));
    }
}
