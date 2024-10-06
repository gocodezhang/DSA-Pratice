public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        // totalWaitTime
        long totalWaitTime = 0;
        long currTime = customers[0][0];

        // go through the array
        for (int i = 0; i < customers.length; i++) {
            int[] customer = customers[i];
            // find out how long the customer has been waiting (before processing its order)
            long waitingTime = currTime - customer[0];
            // find out how long we need to process the order
            long processingTime = customer[1];
            if (waitingTime < 0) {
                totalWaitTime += processingTime;
                currTime = customer[0] + processingTime;
            } else {
                totalWaitTime += waitingTime + processingTime;
                currTime += processingTime;
            }
        }

        // return totalWaitTime / length
        return (double) totalWaitTime / customers.length;
    }
    public static void main(String[] args) {
        int[][] customers = {
                {5,2},{5,4},{10,3},{20,1},
        };
        AverageWaitingTime averageWaitingTime = new AverageWaitingTime();
        System.out.println(averageWaitingTime.averageWaitingTime(customers));
    }
}
