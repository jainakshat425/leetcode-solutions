class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        while( fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            
            if( slow == fast )
                return slow == 1;
        }
        return true;
    }
    
    private int getNext(int n) {
        int sum = 0;

        while( n != 0 ) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
/*
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet();
        
        while( n != 1 ) {
            int temp = n;
            int sum = 0;
            
            while( temp != 0 ) {
                sum += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            n = sum;
            
            if( visited.contains( n ) )
                return false;
            
            visited.add(n);
        }
        return true;
    }
}
*/
