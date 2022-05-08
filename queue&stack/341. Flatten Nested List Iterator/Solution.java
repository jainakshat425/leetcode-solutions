/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList();
        
        flatten(nestedList);
    }
    
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    private void flatten(List<NestedInteger> nestedList) {
        Stack<Node> stack = new Stack();
        stack.push( new Node(nestedList, 0) );

        Node curr;

        while( !stack.isEmpty() ) {

            curr = stack.pop();

            int n = curr.list.size();

            // Flatten the list from current list's start index
            for(int i=curr.start; i<n; i++) {

                NestedInteger val = curr.list.get(i);

                // If current val is a integer, no need to flatten, add it to the queue
                if( val.isInteger() ) {
                    queue.offer( val.getInteger() );
                } else {
                    // Push the current list into stack again, if it has not yet completed
                    if( i+1 != n ) {
                        curr.start = i+1;
                        stack.push( curr );
                    }
                    
                    // Push the nested list, so that it can be processed next
                    stack.push( new Node(val.getList(), 0) );
                    break;
                }
            }
        }
    }
    
    class Node {
        List<NestedInteger> list;
        Integer start;
        
        public Node(List<NestedInteger> list, Integer start) {
            this.list = list;
            this.start = start;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
