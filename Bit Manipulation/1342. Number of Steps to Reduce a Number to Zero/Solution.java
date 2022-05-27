class Solution {
    public int numberOfSteps(int num) {
        if( num == 0 )
            return 0;
        int steps = 0;
        
        while( num != 0 ) {
            steps += (num & 1) == 0 ? 1 : 2;
            num = num >> 1;
        }
        return steps-1;
    }
    
    /*
    public int numberOfSteps(int num) {
        if( num == 0 )
            return 0;
        if( num%2 == 0 )
            return 1 + numberOfSteps(num/2);
        return 1 + numberOfSteps(num-1);
    }
    
    public int numberOfSteps(int num) {
        int steps = 0;
        
        while( num != 0 ) {
            steps += 1;
            if( num%2 == 0 )
                num = num/2;
            else 
                num = num-1;
        }
        return steps;
    }
    */
}
