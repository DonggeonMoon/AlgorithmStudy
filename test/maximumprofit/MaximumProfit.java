package maximumprofit;

public class MaximumProfit {
    private MaximumProfit() {
    }

    public static MaximumProfit create() {
        return new MaximumProfit();
    }

    public int calculateMaximumProfit(final int[] prices) {
        int maximumProfit = 0;
        int minimumProfit = prices[0];

        for (final int price : prices) {
            int profit = price - minimumProfit;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }

            if (price < minimumProfit) {
                minimumProfit = price;
            }
        }
        return maximumProfit;
    }
}
