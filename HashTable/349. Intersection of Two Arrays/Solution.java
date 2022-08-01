class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if( nums2.length < nums1.length )
            return intersection(nums2, nums1);
        
        Set<Integer> set = new HashSet();
        for(int num : nums1)
            set.add( num );
        
        Set<Integer> intersection = new HashSet();
        for(int num : nums2)
            if( set.contains(num) )
                intersection.add(num);
        
        int[] ans = new int[intersection.size()];
        Iterator<Integer> it = intersection.iterator();
        for(int i=0; i<ans.length; i++)
            ans[i] = it.next();
        return ans;
    }
}
