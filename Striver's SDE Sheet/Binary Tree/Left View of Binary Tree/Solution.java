class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if( root == null ) return ans;
        
        Queue<Node> queue = new LinkedList();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
          
            ans.add( queue.peek().data );
            
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();
                
                if( curr.left != null ) {
                    queue.offer( curr.left );
                }
                if( curr.right != null ) {
                    queue.offer( curr.right );
                }
            }
        }
        return ans;
    }
}
