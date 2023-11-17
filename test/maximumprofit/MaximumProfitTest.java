package maximumprofit;

import org.junit.jupiter.api.Test;

public class MaximumProfitTest {
    @Test
    void testMaximumProfit() {
        MaximumProfit maximumProfit = MaximumProfit.create();

        int[] prices = {10300, 9600, 9800, 8200, 7800, 8300, 9500, 9800, 10200, 9500};

        int result = maximumProfit.calculateMaximumProfit(prices);

        System.out.println("result = " + result);
    }
}
