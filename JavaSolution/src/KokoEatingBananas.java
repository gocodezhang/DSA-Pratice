public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < piles.length; i++) {
            if (right < piles[i]) {
                right = piles[i];
            }
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (checkSpeed(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;

    }

    public static Boolean checkSpeed(int speed, int[] piles, int h) {
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            int time = (int) Math.ceil((double) piles[i] / speed);
            total += time;
        }

        return total <= h;
    }
    public static void main(String[] args) {
        int[] piles = new int[] {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, 8));
    }
}