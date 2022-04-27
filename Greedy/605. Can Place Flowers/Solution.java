class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int len = flowerbed.length;
        
        int i=0;
        
        while( i < len ) {
            
            // Return true, if all the flowers can be placed
            if( n == 0 ) return true;
            
            /* Skip current and next position if current position is 
            already occupied */
            if( flowerbed[i] == 1 ) {
                i += 2;
                continue;
            }
            
            // Either first position or no flower in the previous position
            boolean prevOk = (i == 0 || flowerbed[i-1] == 0);
            // Either last position or no flower in the next position
            boolean nextOk = (i == len-1 || flowerbed[i+1] == 0);
            
            // If there is no flower in the previous and next position
            if( prevOk && nextOk ) {
                // Decrement count of flowers to place
                n--;
                
                // Skip next position 
                i += 2;
            } else {
                i++;
            }
        }
        
        return n == 0;
    }
}
