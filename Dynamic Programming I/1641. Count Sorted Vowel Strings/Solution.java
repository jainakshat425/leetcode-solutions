class Solution {
    
    public int countVowelStrings(int n) {
        int[] permutations = new int[]{1,1,1,1,1};
        
        for(int i=0; i<n; i++) {
            /* Start from the last second index ie. index of 'o', because after
            fixing 'u' different combinations cannot be form */
            for(int j=3; j>=0; j--) {
                permutations[j] = permutations[j+1] + permutations[j];   
            }
        }
            
        return permutations[0];
    }
}
