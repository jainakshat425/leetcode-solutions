class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int ans = 0;
        
        for(int num : time) {
            ans += count[(600-num)%60];
            count[num%60] += 1;
        }
        return ans;
    }
}
