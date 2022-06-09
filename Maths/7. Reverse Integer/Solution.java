class Solution {
    public int reverse(int x) {
        int ans = 0;
        int posThreshold = Integer.MAX_VALUE/10;
        int negThreshold = Integer.MIN_VALUE/10;
        
        while( x != 0 ) {
            int num = (x%10);

            if( ans > posThreshold || (ans == posThreshold && num > 7 ) )
                return 0;
            if( ans < negThreshold || (ans == negThreshold && num < -8 ) ) 
                return 0;
                
            ans = (ans*10) + num;
            x /= 10;
        }
        
        return ans;
    }
}
