class GfG
{
    int maxLen(int arr[], int n)
    {
        Map<Integer,Integer> sumMap = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        
        for(int i=0; i<n; i++) {
            
            sum += arr[i];
            
            if( sum == 0 ) {
                max = Math.max( max, i+1 );
                
            } else if( sumMap.containsKey( sum ) ) {
                int prevSumIndex = sumMap.get( sum );
                int curr = i - prevSumIndex;
                
                if( curr > max ) {
                    max = curr;
                }
            } else {
                sumMap.put( sum, i );
            }
        }
        return max;
    }
}
