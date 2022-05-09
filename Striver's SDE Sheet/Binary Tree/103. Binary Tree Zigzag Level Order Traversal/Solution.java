class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        
        if( root == null ) return ans;
        
        // Queue for level order traversal of tree
        Queue<TreeNode> queue = new LinkedList();
        queue.add( root );
        
        // If reverse is true, add values of current level in reverse order
        boolean reverse = false;
        
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            // Use LinkedList instead of ArrayList, because of insert from front
            List<Integer> list = new LinkedList();
            ans.add( list );
            
            // Iterate for nodes in current level
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                
                if( node.left != null ) 
                    queue.offer( node.left );
                
                if( node.right != null ) 
                    queue.offer( node.right );
                
                // If current level has to be reversed, add nodes from front
                if( reverse ) {
                    list.add( 0, node.val );
                } else {
                    list.add( node.val );
                }
            }
            
            // Reverse the reverse flag
            reverse = !reverse;
        }
        return ans;
    }
}
