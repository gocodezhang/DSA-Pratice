import java.util.Arrays;

public class MergeTripletsFromTarget {
    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] marks = new int[target.length];
        // iterate trough triplets
        for (int i = 0; i < triplets.length; i++) {
            // currTriplet
            int[] currTriplet = triplets[i];
            // if any elelments in CT > target T
            boolean usefulTriplet = true;
            for (int j = 0; j < currTriplet.length; j++) {
                if (currTriplet[j] > target[j]) {
                    usefulTriplet = false;
                }
            }
            if (!usefulTriplet) {
                continue;
            }
            // search if any elements in CT == corresponding elements in target
            for (int j = 0; j < currTriplet.length; j++) {
                if (currTriplet[j] == target[j]) {
                    marks[j] = 1;
                }
            }
        }
        return Arrays.stream(marks).sum() == 3;
    }
    public static void main(String[] args) {
        int[][] triplets = {
            {2,5,3}, {1,8,4}, {1, 7, 5}
        };
        int[] target = {2, 7, 5};
        System.out.println(mergeTriplets(triplets, target));
    }
}
