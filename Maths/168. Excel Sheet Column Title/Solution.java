class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        
        while( columnNumber > 0 ) {
            columnNumber -= 1;
            builder.append( (char)('A' + columnNumber%26) );
            columnNumber /= 26;
        }
        return builder.reverse().toString();
    }
}
