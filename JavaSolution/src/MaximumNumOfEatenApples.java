import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        // create a heap to store apple and expire
        int eaten = 0;
        PriorityQueue<int[]> appleStore = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // go through apples and days
        for (int i = 0; i < n; i++) {
            // add the apples into heap
            appleStore.add(new int[]{apples[i], days[i] + i});
            // eat apple
            while (!appleStore.isEmpty() && appleStore.peek()[1] <= i) {
                appleStore.poll();
            }
            if (!appleStore.isEmpty()) {
                int[] applePile = appleStore.peek();
                applePile[0]--;
                eaten++;
                if (applePile[0] == 0) {
                    appleStore.poll();
                }
            }
        }

        // clean up the remaining
        int day = n;
        while (!appleStore.isEmpty()) {
            int[] pile = appleStore.poll();
            eaten += Math.min(pile[0], pile[1] - day);
            day = Math.min(pile[1], day + pile[0]);
        }

        return eaten;
    }
    public static void main(String[] args) {
        int[] apples = {2, 1, 10};
        int[] days = {2,10,1};
        MaximumNumOfEatenApples maximumNumOfEatenApples = new MaximumNumOfEatenApples();
        System.out.println(maximumNumOfEatenApples.eatenApples(apples, days));
    }
}
