class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
/*
class Solution {
    public boolean isPowerOfThree(int n) {
        double num = n;
        while( num > 3 ) 
            num /= 3;
        return num == 1 || num == 3;
    }
}*/
