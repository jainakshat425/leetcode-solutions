class Solution {
    public boolean divisorGame(int n) {
        return n%2 == 0;
        /* 
        given n 
        choose x, such that n%x == 0, where 0 < x < n
        
        Alice start first, return true if Alice can win
        */
    }
}
