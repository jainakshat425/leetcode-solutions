class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer,Integer> hdToNodeVal = new TreeMap<Integer,Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        
        queue.offer( new Tuple(root, 0) );
        
        while( !queue.isEmpty() ) {
            
            Tuple tuple = queue.poll();
            
            int hd = tuple.hd;
            
            if( !hdToNodeVal.containsKey( hd ) ) {
                hdToNodeVal.put( hd, tuple.node.data );
            }
            
            if( tuple.node.left != null ) {
                queue.offer( new Tuple(tuple.node.left, hd-1) );
            }
            if( tuple.node.right != null ) {
                queue.offer( new Tuple(tuple.node.right, hd+1) );
            }
        }
        
        for(Integer val : hdToNodeVal.values()){
            ans.add( val );
        }
        return ans;
    }
}
class Tuple {
    Node node;
    int hd;
    
    public Tuple(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
