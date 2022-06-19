class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] countToNums = new ArrayList[n+1];
        Map<Integer,Integer> numToCount = new HashMap();
        int[] ans = new int[k];
        
        for(int num : nums)
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        
        for(int num : numToCount.keySet()) {
            int count = numToCount.get(num);
            if( countToNums[count] == null )
                countToNums[count] = new ArrayList();
            countToNums[count].add(num);
        }
        
        
        for(int count=n; count>0; count--) {
            if( countToNums[count] == null )
                continue;
            for(int num : countToNums[count]) {
                ans[--k] = num;
                
                if(k == 0)
                    break;
            }
            if(k == 0)
                break;
        }
        return ans;
    }
}
