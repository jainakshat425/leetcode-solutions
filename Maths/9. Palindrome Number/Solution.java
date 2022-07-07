class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 || (x%10 == 0 && x != 0))
            return false;
        
        int revertedNum = 0;
        
        while( x > revertedNum ) {
            revertedNum = (revertedNum * 10) + (x % 10);
            x /= 10;
        }
        
        return x == revertedNum || x == revertedNum/10;
    }
}
// class Solution {
//     public boolean isPalindrome(int x) {
//         if( x < 0 )
//             return false;
        
//         List<Integer> nums = new ArrayList();
        
//         while( x > 0 ) {
//             nums.add( x % 10 );
//             x /= 10;
//         }
        
//         int start = 0, end = nums.size()-1;
        
//         while( start < end )
//             if( nums.get(start++) != nums.get(end--) )
//                 return false;
        
//         return true;
//     }
// }
