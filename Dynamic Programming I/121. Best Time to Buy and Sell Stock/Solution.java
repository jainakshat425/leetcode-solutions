class Solution {
    public int maxProfit(int[] prices) {
      
        /* 
        1. Initialize {profit} with 0 and {min} with the price of first day.
        2. Iterate from the second day to last day
            - If current day price {prices[i]} < minmum price [min], update {min}
            - else if profit to sell on current day {prices[i]-min} > {profit}, update {profit}.
        */
        // Initialize {profit} with 0 and {min} with the price of first day.
        int profit = 0;
        int min = prices[0];
             
        // Iterate from the second day to last day
        for(int i=1; i<prices.length; i++) {
            
            // If current day price {prices[i]} < minmum price [min], update {min}
            if( prices[i] < min ) {
                min = prices[i];
            } else {
                // else if profit to sell on current day {prices[i]-min} > {profit}, update {profit}.
                profit = Math.max(profit, prices[i]-min);
            }            
        }

        return profit;
    }
}
