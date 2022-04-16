class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        Stack<Integer> stack = new Stack<Integer>();
        int[] answers = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            
            while( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ) {
                int top = stack.pop();
                answers[top] = i - top;
            }

            stack.push( i );
        }
        return answers;
        */
        /* 
        1. Iterate from the last to first
            - If current temperature is hottest, then there is no warmer temperature ahead.
            - While the current day temperature >= next day temperature
                - Find the day at which temperature is warmer for the next day.     
            - Store the day {days} at which temperature will be warmer for the current day {currDay}
        */
        int n = temperatures.length;
        int[] answers = new int[temperatures.length];
        int hottest = 0;
        
        // Iterate from the last to first
        for(int currDay = n-1; currDay >= 0; currDay--) {
            
            int currTemp = temperatures[currDay];
            
            // If current temperature is hottest, then there is no warmer temperature ahead.
            if( currTemp >= hottest ) {
                hottest = currTemp;
                continue;
            }
            
            int days = 1;
            
            // While the current day temperature >= next day temperature
            while( currTemp >= temperatures[currDay+days] ) {
                // Find the day at which temperature is warmer for the next day.                
                days += answers[currDay+days];
            }
            
            // Store the day {days} at which temperature will be warmer for the current day {currDay}
            answers[currDay] = days;
        }
        return answers;
    }
}
