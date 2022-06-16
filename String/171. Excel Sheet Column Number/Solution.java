class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int num = 0;
        
        for(int i=0; i<n; i++) 
            num = (num*26) + letterToNum( columnTitle.charAt(i) );
        
        return num;
    }
    
    private int letterToNum(char letter) {
        return (letter - 'A') + 1;
    }
}
