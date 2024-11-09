public class BestTimeToBSStock {
    public int maxProfit(int[] prices) {
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
    public int maxProfitCleanVersion(int[] prices) {
        int maxProfit = 0;
        int lowestPoint = prices[0];
        for (int i = 1; i < prices.length; i++) {
            lowestPoint = Math.min(lowestPoint, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowestPoint);
        }

        return maxProfit;
    }
    public int maxProfitUsingExtraMemory(int[] prices) {
        // minPrices contain the min price til i index (from start to end)
        int[] minPrices = new int[prices.length];
        // maxPrices contain the max price til i index (from end to start)
        int[] maxPrices = new int[prices.length];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            minPrices[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxPrices[i] = max;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxPrices[i] - minPrices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBSStock bestTimeToBSStock = new BestTimeToBSStock();
        System.out.println(bestTimeToBSStock.maxProfit(prices));
    }
}
