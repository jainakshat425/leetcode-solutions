public class Solution {
    public int solve(int[] A, int B) {

        //|--------xor-----|
        //|-----y----|--B--|
    
        // y^k = xor
        // y = xor^B
        // No. of times y appears == count

        Map<Integer,Integer> xorToFrequencyMap = new HashMap<>();

        int xor = 0;
        int count = 0;

        for(int num : A) {

            xor ^= num;

            if( xor == B ) {
                ++count;
            } 
            int y = B ^ xor;

            if( xorToFrequencyMap.containsKey( y ) ) {
                count += xorToFrequencyMap.get( y );
            }

            // Update Frequency in the map
            int freq = 0;
            if( xorToFrequencyMap.containsKey( xor ) ) {
                freq = xorToFrequencyMap.get( xor );
            }
            xorToFrequencyMap.put( xor, freq + 1 );
        }
        return count;
    }
}
