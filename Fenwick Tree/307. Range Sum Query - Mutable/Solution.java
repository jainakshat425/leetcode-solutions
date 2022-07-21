class NumArray {
    private int n;
    private int[] nums;
    private int[] tree;
    
    public NumArray(int[] arr) {
        n = arr.length;
        nums = arr;
        tree = new int[n+1];
        buildTree(nums);
    }
    
    public void update(int index, int val) {
        updateTree(index+1, val-nums[index]);
        nums[index] = val;
    }
        
    public int sumRange(int left, int right) {
        return prefixSum(right+1) - prefixSum(left);
    }
    
    public void updateTree(int index, int val) {
        while( index <= n ) {
            tree[index] += val;
            index += lsb(index);
        }
    }
    
    private int lsb(int i) {
        return i & -i;
    }
    
    private int prefixSum(int index) {
        int sum = 0;
        
        while( index > 0 ) {
            sum += tree[index];
            index -= lsb(index);
        }
        return sum;
    }
    
    private void buildTree(int[] nums) {
        for(int i=0; i<n; i++) 
            tree[i+1] = nums[i];
             
        for(int i=1; i<=n; i++) {
            int j = i + lsb(i);
            
            if( j <= n )
                tree[j] += tree[i];
        }
    }
    
}
// class NumArray {
//     private int n;
//     private int[] tree;
    
//     public NumArray(int[] nums) {
//         n = nums.length;
//         tree = new int[n*4];
//         buildTree(0, 0, n-1, nums);
//     }
    
//     public void update(int index, int val) {
//         update(0, 0, n-1, index, val);
//     }
    
//     public int sumRange(int left, int right) {
//         return sumRange(0, 0, n-1, left, right);
//     }
    
//     private void update(int treeInd, int lo, int hi, int index, int val) {
//          // no overlap
//         if( lo > hi || index > hi || index < lo )
//             return;
        
//         // base case: leaf node
//         if( lo == hi ) {
//             tree[treeInd] = val;
//             return;
//         }
       
//         int mid = lo + (hi-lo)/2;
        
//         update(2*treeInd+1, lo, mid, index, val);
//         update(2*treeInd+2, mid+1, hi, index, val);
        
//         tree[treeInd] = tree[2*treeInd+1] + tree[2*treeInd+2];
//     }
    
//     private int sumRange(int treeInd, int lo, int hi, int left, int right) {
//         // no overlap
//         if( lo > hi || left > hi || right < lo )
//             return 0;
            
//         // complete overlap
//         if( lo >= left && hi <= right )
//             return tree[treeInd];
        
//         // partial overlap
//         int mid = lo + (hi-lo)/2;
        
//         int leftSum = sumRange(2*treeInd+1, lo, mid, left, right);
//         int rightSum = sumRange(2*treeInd+2, mid+1, hi, left, right);
        
//         // merge
//         return leftSum + rightSum;
//     }
    
//     private void buildTree(int treeInd, int lo, int hi, int[] nums) {
//         // base case: leaf node
//         if( lo == hi ) {
//             tree[treeInd] = nums[lo];
//             return;
//         }
        
//         int mid = lo + (hi-lo)/2;
        
//         buildTree(2*treeInd+1, lo, mid, nums);
//         buildTree(2*treeInd+2, mid+1, hi, nums);
        
//         tree[treeInd] = tree[2*treeInd+1] + tree[2*treeInd+2];
//     }
    
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * obj.update(index,val);
//  * int param_2 = obj.sumRange(left,right);
//  */
