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
    public int maxDepth(Node root) {
        return maxDepth( root, 0 );
    }
    
    private int maxDepth(Node root, int depth) {
        if( root == null ) {
            return depth;
        }
        
        depth++;
        
        int max = depth;
        
        for(Node child : root.children) {
            max = Math.max( max, maxDepth( child, depth ) );
        }
        
        return max;
    }
}
