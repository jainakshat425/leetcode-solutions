class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        Node curr = root;
        
        while( curr != null ) {
            if( curr.data > key ) {
                s.succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        curr = root;
        
        while( curr != null ) {
            if( curr.data < key ) {
                p.pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }
}
