class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        /* hd (horizontal distance) is position on x axis, root lies at 0, 
        left subtree starts at -1 and right subtree starts at +1 */
        Map<Integer,Integer> hdToNode = new TreeMap<Integer,Integer>();
        root.hd = 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            // Put current node and it's horizontal distance into map
            Node node = queue.poll();
            
            int hd = node.hd;
            hdToNode.put( hd, node.data );
            
            Node left = node.left;
            Node right = node.right;
            
            // Add left and right node to the queue with there horizontal distance
            if( left != null ) {
                left.hd = hd-1;
                queue.offer( left );
            }
            if( right != null ) {
                right.hd = hd+1;
                queue.offer( right );
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Integer val : hdToNode.values()) {
            ans.add( val );
        }
        return ans;
    }
}
