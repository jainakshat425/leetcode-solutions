class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int low = 0, high = 0;
        
        for(int i=0; i<n; i++) {
            switch( s.charAt(i) )  {
                case '(': 
                    low++;
                    high++;
                    break;
                case '*': 
                    low--;
                    high++;
                    break;
                case ')': 
                    low--;
                    high--;
                    break;
            }
            if( high < 0 )
                return false;
            if( low < 0 )
                low = 0;
        }
        return low == 0;
    }
}
