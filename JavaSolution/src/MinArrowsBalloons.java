import java.util.Arrays;

public class MinArrowsBalloons {
    public int findMinArrowShots(int[][] points) {
        // sort points based on first points
        Arrays.sort(points, (a,b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] == b[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int numOfShots = 1;
        int lastShotIndex = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (lastShotIndex >= points[i][0]) {
                lastShotIndex = Math.min(lastShotIndex, points[i][1]);
                continue;
            }
            numOfShots += 1;
            lastShotIndex = points[i][1];
        }
        return numOfShots;
    }
    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        MinArrowsBalloons minArrowsBalloons = new MinArrowsBalloons();
        System.out.println(minArrowsBalloons.findMinArrowShots(points));
    }
}
