class Solution {
    public boolean isPossible(int[] target) {  
        long sum = 0;
        int maxInd = 0;
        
        for(int i=0; i<target.length; i++) {
            sum += target[i];
            if( target[i] > target[maxInd] )
                maxInd = i;
        } 
        sum -= target[maxInd];
        
        if( target[maxInd] == 1 || sum == 1 )
            return true;
        
        if( sum > target[maxInd] || sum == 0 || target[maxInd]%sum == 0 )
            return false;
        
        target[maxInd] %= sum;
        
        return isPossible(target);
    }
}
/* 
class Solution {
    public boolean isPossible(int[] target) {  
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        
        for(int i=0; i<target.length; i++) {
            sum += target[i];
            maxHeap.offer( target[i] );
        } 
        
        while( maxHeap.peek() != 1 ) {
            int max = maxHeap.poll();
            
            sum -= max;
            
            if( sum == 1 )
                return true;

            if( sum > max || sum == 0 || max%sum == 0 )
                return false;

            max %= sum;
            sum += max;
            
            maxHeap.offer( max );
        }
        return true;
    }
}
*/
/* TLE
class Solution {
    public boolean isPossible(int[] target) {  
        int n = target.length;
        // 0 > target value, 1 > value at corresponding index in sum array
        Queue<int[]> queue = new LinkedList();
        int sum = n;
        
        Arrays.sort(target);
        
        for(int t : target) {
            if( t != 1 )
                queue.offer(new int[]{ t, 1 });
        }
        
        while( !queue.isEmpty() ) {
            int[] curr = queue.poll();
            
            if( sum > curr[0] )
                return false;
            
            if( sum < curr[0] ) {
                int temp = sum;
                sum = 2 * sum - curr[1];
                curr[1] = temp;
                
                queue.offer(curr);
            } else 
                sum = 2 * sum - curr[1];
            
        }
        
        return true;
    }
}
*/
