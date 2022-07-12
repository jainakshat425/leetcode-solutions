class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        int prefix = n, suffix = 0;
        int pos = 1;

        while( prefix > 0 ) {
            int digit = prefix % 10;
            
            prefix /= 10;
            
            suffix += digit * pos;
            
            ans += (prefix * pos);
            
            if( digit == 1 ) 
                ans += suffix - pos + 1;

            else if( digit != 0 )
                ans += pos;

            pos = pos * 10;
        }
        return ans;
    }
}
// class Solution {
//     public int countDigitOne(int n) {
//         int ans = 0;
//         String digits = n + "";
//         int len = digits.length();
//         int acc = 0;

//         for(int i=0; i<len; i++) {
//             char digit = digits.charAt(i);
//             int digitPlace = (int)Math.pow(10, len-i-1);
//             ans += (acc * digitPlace);
            
//             if( digit == '1' ) {
//                 int numFromI = Integer.parseInt(digits.substring(i, len));
//                 ans += numFromI - digitPlace + 1;
//             }
//             else if( digit != '0' )
//                 ans += digitPlace;

//             acc = acc * 10 + (digit-'0');
//         }
//         return ans;
//     }
// }
// class Solution {
//     public int countDigitOne(int n) {
//         int ans = 0;
//         int numStart = 0;
        
//         while( numStart < n ) {
//             int count = count1( numStart );
//             ans += (count*10) + 1;
            
//             numStart += 10;
            
//             if( numStart > n ) {
//                 ans -= (numStart - n - 1) * count;
//                 break;
//             }
//         }
//         if( numStart == n )
//             ans += count1( numStart );
        
//         return ans;
//     }
    
//     private int count1(int n) {
//         int cnt = 0;
        
//         while( n > 0 ) {
//             cnt += n % 10 == 1 ? 1 : 0;
//             n /= 10;
//         }
//         return cnt;
//     }
// }
