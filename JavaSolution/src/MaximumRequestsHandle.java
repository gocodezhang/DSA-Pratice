import java.util.Arrays;
import java.util.List;

/**
 * Find the maximum number of requests we can handle
 * serverCapacities: original capacity for each server
 * incomingRequests: incoming requests to handled by each server
 * K: can double k servers capacity
 */
public class MaximumRequestsHandle {
    public long maximumRequests(List<Integer> serverCapacities, List<Integer> incomingRequests, int k) {
        int n = serverCapacities.size();
        long[] handled = new long[n];
        int[] unhandled = new int[n];

        for (int i = 0; i < n; i++) {
            handled[i] = Math.min(serverCapacities.get(i), incomingRequests.get(i));
            // unhandled is bound by difference between reuests & capacity but also original capacity
            unhandled[i] = Math.min(incomingRequests.get(i) - serverCapacities.get(i), serverCapacities.get(i));
        }

        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> unhandled[b] - unhandled[a]);

        for (int i = 0; i < k; i++) {
            int targetIndex = index[i];
            if (unhandled[targetIndex] > 0) {
                long updatedHandle = Math.min(serverCapacities.get(targetIndex) * 2, incomingRequests.get(targetIndex));
                handled[targetIndex] = updatedHandle;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += handled[i];
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> servers = List.of(4,5,8,1,10);
        List<Integer> requests = List.of(5,2,10,20,9);
        MaximumRequestsHandle maximumRequestsHandle = new MaximumRequestsHandle();
        System.out.println(maximumRequestsHandle.maximumRequests(servers,requests,1));
    }
}
