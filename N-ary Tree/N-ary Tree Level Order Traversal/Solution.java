/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if( root == null ) return ans;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            List<Integer> level = new ArrayList<>(size);
            ans.add( level );
            
            for(int i=0; i<size; i++) {
                
                Node curr = queue.poll();
                level.add( curr.val );
                
                for(Node child : curr.children) {
                    queue.offer( child );
                }
            }
        }
        
        return ans;
    }
}
