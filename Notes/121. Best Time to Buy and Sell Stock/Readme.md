https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

        1. Start with max profit = 0 and buy day as first day
        2. Iterate from 2nd day to last day in prices
            - If the price of curr day is less than buy day
                - We cannot sell on this day, as it will incur loss
                - But be can buy on this day instead, as price is lower on curr day
            - else, sell on curr day
                - update max profit if selling curr day generates more profit.
        
        Time - n
        space - 1
