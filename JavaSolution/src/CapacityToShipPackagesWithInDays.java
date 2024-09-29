import java.util.HashMap;

public class CapacityToShipPackagesWithInDays {
    public int shipWithinDays(int[] weights, int days) {
        // find out binary search range and build maps
        int maxWeight = 0;
        int totalWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            int currWeight = weights[i];
            totalWeight += currWeight;
            maxWeight = Math.max(currWeight, maxWeight);
        }
        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = (left + right) / 2;
            int requiredDays = calculateDays(mid, weights);
            if (requiredDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    public int calculateDays(int capacity, int[] weights) {
        int days = 0;
        int currLoads = 0;
        for (int i = 0; i < weights.length; i++) {
            currLoads += weights[i];
            if (currLoads > capacity) {
                days++;
                currLoads = weights[i];
            }
        }
        if (currLoads > 0) {
            days++;
        }
        return days;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        CapacityToShipPackagesWithInDays capacityToShipPackagesWithInDays = new CapacityToShipPackagesWithInDays();
        System.out.println(capacityToShipPackagesWithInDays.shipWithinDays(weights, days));
    }
}
