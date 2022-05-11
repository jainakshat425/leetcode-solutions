class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        Stack<Node> stack = new Stack<Node>();
        
        while( root != null || !stack.isEmpty() ) {
            
            while( root != null ) {
                stack.push(root);
                root = root.right;
            }
            
            root = stack.pop();
            
            if( --K == 0 ) return root.data;
            
            root = root.left;
        }
        return -1;
    }
}
