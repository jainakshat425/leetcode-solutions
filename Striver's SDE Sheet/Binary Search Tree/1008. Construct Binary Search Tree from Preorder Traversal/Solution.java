class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = new int[]{ 0 };
        return bstFromPreorder(preorder, Integer.MAX_VALUE, i);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if( i[0] == preorder.length || preorder[i[0]] > bound ) 
            return null;
        
        TreeNode root = new TreeNode( preorder[i[0]] );
        i[0]++;
        
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        
        return root;
    }
    /*
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return bstFromPreorder(preorder, 0, n-1);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        
        if( start > end ) return null;
        
        TreeNode root = new TreeNode( preorder[start] );
        
        int pivot = binarySearch(preorder, start+1, end, preorder[start]);
        
        // while( pivot <= end && preorder[pivot] < preorder[start] ) {
        //     pivot++;
        // }
        
        root.left = bstFromPreorder(preorder, start+1, pivot-1);
        root.right = bstFromPreorder(preorder, pivot, end);
        
        return root;
    }
    
    private int binarySearch(int[] nums, int low, int high, int num) {
        if( low > high ) return low;
        
        int mid = low + (high-low)/2;
        
        if( nums[mid] < num ) 
            return binarySearch(nums, mid+1, high, num);
        
        return binarySearch(nums, low, mid-1, num);
    }
    */
}
