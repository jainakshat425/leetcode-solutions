class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return constructTree(nums, 0, n-1);
    }
    
    private TreeNode constructTree(int[] nums, int start, int end) {
        if( start > end ) 
            return null;
        
        int mid = start + (end-start)/2;
        
        TreeNode root = new TreeNode( nums[mid] );
        
        root.left = constructTree(nums, start, mid-1);
        root.right = constructTree(nums, mid+1, end);
        
        return root;
    }
}
