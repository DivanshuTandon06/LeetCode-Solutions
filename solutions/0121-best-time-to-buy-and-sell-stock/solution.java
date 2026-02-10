class Solution {
    public int maxProfit(int[] prices) {
        // 1. Handle edge case for empty or single-element arrays
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Initialize to a very high number
        int maxProfit = 0; // Initialize profit to 0

        // 2. Iterate through the array only once
        for (int price : prices) {
            // Update the minimum price if we find a cheaper buying day
            if (price < minPrice) {
                minPrice = price;
            } 
            // If current price is not lower, check if selling today yields a better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
