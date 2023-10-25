public class BestTimeToBSStock {
    public static int maxProfit(int[] prices) {
        // left = 0, maxProfit = 0
        int left = 0;
        int maxProfit = 0;
        // for (right = 0; right < length)
        for (int right = 0; right < prices.length; right++) {
            // if (prices[left] > prices[right]
            if (prices[left] > prices[right]) {
                left = right;
            }
            // currProfit = prices[right] - prices[left]
            // maxProfit = math.max(currProfit, maxProfit)
            maxProfit = Math.max(prices[right] - prices[left], maxProfit);
        }
        // return maxProfit
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
