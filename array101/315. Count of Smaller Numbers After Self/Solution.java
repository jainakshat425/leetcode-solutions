class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList(n);
        Pair<Integer,Integer>[] pairs = new Pair[n];
        for(int i=0; i<n; i++) {
            pairs[i] = new Pair(i, nums[i]);
            ans.add(0);
        }
        mergeSort(0, n-1, pairs, ans);
        return ans;
    }
    
    private void mergeSort(int start, int end, Pair<Integer,Integer>[] nums, List<Integer> count) {
        if( start < end ) {
            int mid = start + (end-start)/2;
            
            mergeSort(mid+1, end, nums, count);
            mergeSort(start, mid, nums, count);
            
            merge(start, mid, end, nums, count);
        }
    }
    
    private void merge(int start, int mid, int end, Pair<Integer,Integer>[] nums, List<Integer> count) {
        int n = end-start+1;
        int i=start, j=mid+1, k=0;
        Pair<Integer,Integer>[] sorted = new Pair[n];
        
        while( i<=mid && j<=end ) {
            if( nums[i].getValue() > nums[j].getValue() ) {
                count.set(nums[i].getKey(), count.get(nums[i].getKey()) + end-j+1);
                sorted[k++] = nums[i++];
            } else 
                sorted[k++] = nums[j++]; 
        }
        
        while( i <= mid ) 
            sorted[k++] = nums[i++];
        
        while( j <= end ) 
            sorted[k++] = nums[j++];
        
        for(k = 0; k < n; k++) 
            nums[start++] = sorted[k];
    }
    
    /* 
    private void merge(int start, int mid, int end, List<Pair<Integer,Integer>> nums, List<Integer> count) {
        int n1 = mid+1 - start;
        int n2 = end - mid;
        List<Pair<Integer,Integer>> nums1 = new ArrayList(n1);
        List<Pair<Integer,Integer>> nums2 = new ArrayList(n2);
        
        for(int i=0; i<n1; i++)
            nums1.add( nums.get(start+i) );
        
        for(int i=0; i<n2; i++)
            nums2.add( nums.get(mid+1+i) );
        
        int i=0, j=0;
        while( i<n1 && j<n2 ) {
            Pair<Integer,Integer> p1 = nums1.get(i);
            Pair<Integer,Integer> p2 = nums2.get(j);
            
            if( p1.getValue() > p2.getValue() ) {
                count.set(p1.getKey(), count.get(p1.getKey()) + n2-j);
                i++;
            } else j++;
        }
        
        i=0;
        j=0;
        int k=start;
        
        while( i<n1 && j<n2 ) {
            Pair<Integer,Integer> p1 = nums1.get(i);
            Pair<Integer,Integer> p2 = nums2.get(j);
            
            if( p1.getValue() >= p2.getValue() ) {
                nums.set(k++, p1); 
                i++;
            } else {
                nums.set(k++, p2); 
                j++;
            }
        }
         
        while( i < n1 ) {
            nums.set(k++, nums1.get(i++));
        }
        
        while( j < n2 ) {
            nums.set(k++, nums2.get(j++));
        }
    }
    */
}
