class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while( curr != null || !stack.isEmpty() ) {
            
            while( curr != null ) {
                stack.push( curr );
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            int diff = k - curr.val;
            
            if( set.contains( diff ) ) 
                return true;
            
            set.add( curr.val );
            curr = curr.right;
        }
        return false;
    }
}
/*
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while( curr != null || !stack.isEmpty() ) {
            
            while( curr != null ) {
                stack.push( curr );
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            if( binaryTreeSearch(root, curr, k-curr.val) ) 
                return true;
            
            curr = curr.right;
        }
        return false;
    }
    
    private boolean binaryTreeSearch(TreeNode root, TreeNode curr, int num) {
        
        if( root == null )
            return false;
        
        if( root != curr && root.val == num ) 
            return true;
        
        if( root.val > num )
            return binaryTreeSearch(root.left, curr, num);
        
        return binaryTreeSearch(root.right, curr, num);
    }
}*/
