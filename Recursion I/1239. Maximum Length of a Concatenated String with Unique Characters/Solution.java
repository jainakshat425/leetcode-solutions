class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        // 0 > bit mask of ith string, 1 > length of the ith string
        int[][] masks = new int[n][2];
        
        // Generate bit mask of each string
        for(int i=0; i<n; i++) {
            
            String str = arr.get(i);
            masks[i][1] = str.length();

            for(int j=0; j<str.length(); j++) {
                int bitInd = str.charAt(j) - 'a';
                
                // If duplicate char found in curr string, set the size and mask to 0
                if( (masks[i][0] & (1 << bitInd)) != 0 ) {
                    masks[i][0] = 0;
                    masks[i][1] = 0;
                    break;
                }
                // include current character in mask
                masks[i][0] |= (1 << bitInd);
            }
        }
        return maxLen(0, 0, masks);
    }
    
    private int maxLen(int i, int curr, int[][] masks) {
        if( i == masks.length )
            return 0;
        
        int notTake = maxLen(i+1, curr, masks);
        int take = 0;
        // include current string iff no common characters are found
        if( (masks[i][0] & curr) == 0 )
            take = masks[i][1] + maxLen(i+1, masks[i][0] | curr, masks);
        
        return Math.max(notTake, take);
    }
}
