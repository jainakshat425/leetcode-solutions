class Solution{
    // Available coins
    private static int[] COINS = new int[]{
        2000, 500, 200, 100, 50, 20, 10, 5, 2, 1
    };
    
    static List<Integer> minPartition(int N)
    {
        // Store denominations required make a change for N
        List<Integer> denominations = new LinkedList<>();
        
        // Points to a coin in {COINS} array
        int i = 0;
        
        // Repeat while remaining target doesn't reaches 0
        while( N != 0 ) {
            
            // Skip current coin if it's greater than the remaining target
            if( COINS[i] > N ) {
                i++;
                continue;
            }
            
            N -= COINS[i];
            denominations.add( COINS[i] );
        }
        
        return denominations;
    }
}
