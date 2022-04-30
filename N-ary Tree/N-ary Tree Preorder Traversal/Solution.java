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
    public List<Integer> preorder(Node root) {
        List<Integer> traversal = new LinkedList<Integer>();
        
        if( root == null ) {
            return traversal;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.add( root );
        
        while( !stack.isEmpty() ) {
            
            Node curr = stack.pop();
            traversal.add( curr.val );
            
            if( curr.children != null ) {
                
                int n = curr.children.size();
                
                for(int i = n-1; i >= 0; i--) {
                    stack.push( curr.children.get(i) );
                }
            }
           
        }
        
        return traversal;
    }
}
/* Recursive Solution
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> traversal = new LinkedList<Integer>();
        
        preorderTraversal(root, traversal);
        
        return traversal;
    }
    
    private void preorderTraversal(Node root, List<Integer> traversal) { 
        if( root == null ) {
            return;
        }
        
        traversal.add( root.val );
        
        for(Node child : root.children) {
            preorderTraversal( child, traversal );
        }
    }
}
*/
