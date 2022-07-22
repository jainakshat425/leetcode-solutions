class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int windowCount = n-k+1;
        double[] ans = new double[windowCount];
        
        MedianFinder median = new MedianFinder(nums);
        
        for(int i=0; i<k; i++) 
            median.add(i);
                
        ans[0] = median.find();
        
        // Process from second window 
        for(int i=0; i<windowCount-1; i++) {
            median.remove(i);
            median.add(i+k);
            ans[i+1] = median.find();
        }
        return ans;  
    }
}
class MedianFinder {
    private int[] nums;
    private TreeSet<Integer> left, right;
    
    public MedianFinder(int[] nums) {
        this.nums = nums;
        Comparator<Integer> comp = (i,j) -> nums[i] == nums[j] ? i-j : Integer.compare(nums[i], nums[j]);
        left = new TreeSet(comp.reversed());
        right = new TreeSet(comp);
    }
    
    public void add(int i) {
        if( right.size() > left.size() ) {
            right.add( i );
            left.add( right.pollFirst() );
        } else {
            left.add( i );
            right.add( left.pollFirst() );
        }
    }
    
    public void remove(int i) {
        if( !right.remove(i) )
            left.remove(i);
    }
    
    public double find() {
        return right.size() > left.size() ?
            nums[right.first()] :
            ((double)nums[right.first()] + nums[left.first()])/2;
    }
}
// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         /*
//         n = 100, k = 20
        
//         (n-k+1)*(k + klogk)
//         81 * 120 = 9720
        
//         [1,3,-1,-3,5,3,6,7]
//         [-1,1,3]
//         1,
        
//         copy first k numbers from nums into temp arr - O(k)
//         sort the temp arr - O(klogk)
//         iterate n-k+1 windows
//             - search for the start num of the window in temp arr (k)
//             - remove the num (k)
//             - add the new number at correct sorted pos in temp arr (k)
            
//         O(k) + O(klogk) + (n-k+1)(k+k+logk)
//         20 + 100 + 81*60
//         120 + 9720/2
//         */
//         int n = nums.length;
//         int windowCount = n-k+1;
//         double[] ans = new double[windowCount];
        
//         // Prepare first window
//         List<int[]> window = new ArrayList<int[]>();
        
//         for(int i=0; i<k; i++) 
//             window.add(new int[]{i, nums[i]});
        
//         Collections.sort(window, (a,b) -> Integer.compare(a[1], b[1]));
        
//         ans[0] = findMedian(window, k);
        
//         // Process from second window 
//         for(int i=0; i<windowCount-1; i++) {
//             removeItem(window, i);
//             binarySearchInsert(window, new int[]{i+k, nums[i+k]});
//             ans[i+1] = findMedian(window, k);
//         }
//         return ans;  
//     }
    
//     private double findMedian(List<int[]> nums, int n) {
//         return n%2 != 0 ? nums.get(n/2)[1] : ((double)nums.get(n/2 - 1)[1] + nums.get(n/2)[1])/2.0;
//     }
    
//     private void removeItem(List<int[]> nums, int i) {
//         Iterator<int[]> it = nums.listIterator();
        
//         while( it.hasNext() ) {
//             if( it.next()[0] == i )
//                 it.remove();
//         }
//     }
    
//     private void binarySearchInsert(List<int[]> nums, int[] num) {
//         int lo = 0, hi = nums.size()-1;
//         int idx = -1;
        
//         while( lo <= hi ) {
//             int mid = lo + (hi-lo)/2;
            
//             if( nums.get(mid)[1] == num[1] ) {
//                 idx = mid;
//                 break;
//             } else if( nums.get(mid)[1] > num[1] ) {
//                 idx = mid;
//                 hi = mid-1;
//             } else
//                 lo = mid+1;
//         }
        
//         if( idx == -1 )
//             nums.add(num);
//         else
//             nums.add(idx, num);
//     }
// }
