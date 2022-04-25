/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
        // If current sub list is null or it's last sub list
        // then there is nothing to flatten, return root.
	    if( root == null || root.next == null ) {
	        return root;
	    }
	    
	    // Flattening will be done from the end of the list 
	    // Keep calling flatten until we reach the second last sublist
	    Node nextSublistRoot = flatten( root.next );
	    
	    // Merge current sublist with the next sorted sublist
	    // using Merge Sort technique
	    return merge(root, nextSublistRoot);
    }
    
    Node merge(Node list1, Node list2) 
    {
        // We don't yet know which list's first node will going 
        // to be the head of the sorted list
        // Dummy node's bottom will point to the head of the merged list
        Node dummy = new Node(-1);
        
        // Pointer to the last merged node
	    Node tail = dummy;
	    
	    // Repeat until there are nodes in both the list
	    while( list1 != null && list2 != null ) {
	        
	        // Append the node to the bottom of the tail 
	        // from the list which has smaller value
	        if( list1.data > list2.data ) {
	            tail.bottom = list2;
	            list2 = list2.bottom;
	        } else {
	            tail.bottom = list1;
	            list1 = list1.bottom;
	        }
	        // Move pointer to latest merged node
	        tail = tail.bottom;
	    }
	    
	    // Merge list1 to the sorted list if list1 is not traversed completely
	    if( list1 != null ) {
	        tail.bottom = list1;
	    }
	    // Merge list2 to the sorted list if list2 is not traversed completely
	    if( list2 != null ) {
	        tail.bottom = list2;
	    }
	    
	    // Return head of merged list
	    return dummy.bottom;
    }
}
