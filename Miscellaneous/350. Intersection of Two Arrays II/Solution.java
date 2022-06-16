class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> uniqueCount = new HashMap();
        List<Integer> ans = new ArrayList();
        
        for(int num : nums1)
            uniqueCount.put(num, uniqueCount.getOrDefault(num,0) + 1);
        
        for(int num : nums2) {
            if( uniqueCount.containsKey( num ) ) {
                ans.add( num );
                
                int count = uniqueCount.get(num);
                
                if( count == 1 )
                    uniqueCount.remove(num);
                else 
                    uniqueCount.put(num, count-1);
            }
        }
        return listToArr(ans);
    }
    
    private int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}
