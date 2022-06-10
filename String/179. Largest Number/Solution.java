class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        boolean allZeroes = true;
        
        for(int i=0; i<n; i++) {
            if( nums[i] != 0 )
                allZeroes = false;
            strs[i] = nums[i] + "";
        }
        
        if( allZeroes )
            return "0";
            
        Arrays.sort(strs, (s1, s2) -> -(s1+s2).compareTo(s2+s1));
            
        StringBuilder ans = new StringBuilder();
        for(String str : strs) 
            ans.append(str);
        
        return ans.toString();
    }
}
