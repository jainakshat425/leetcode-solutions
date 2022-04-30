class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        
        if( root == null ) return traversal;
        
        Stack<Node> stack = new Stack<>();
        stack.push( root );
        
        while( !stack.isEmpty() ) {
            
            Node curr = stack.pop();
            traversal.add( curr.val );
            
            for(Node child : curr.children) {
                stack.push( child );
            }
        }
        
        Collections.reverse( traversal );
        
        return traversal;
    }
    
}
/*
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        
        postorder(root, traversal);
        
        return traversal;
    }
    
    private void postorder(Node root, List<Integer> traversal) {
        
        if( root == null ) return;
        
        for(Node child : root.children) {
            postorder(child, traversal);
        }
        
        traversal.add( root.val );
    }
}
