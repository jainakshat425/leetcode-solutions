class Solution {
    private final int BILLION = 1000000000;
    private final int MILLION = 1000000;
    
    private final String[] LESS_THAN_10 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
        "Eighteen", "Nineteen"
    };
    private final String[] LESS_THAN_100 = {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    public String numberToWords(int num) {
        if( num == 0 )
            return "Zero";
        
        StringBuilder builder = new StringBuilder();
        
        helper(num, builder);
        
        return builder.toString().trim();
    }
    
    private void helper(int num, StringBuilder builder) {
        if( num == 0 )
            return; 
        
        if( num >= BILLION ) {
            helper(num / BILLION, builder);
            builder.append("Billion ");
            helper(num % BILLION, builder);
        }
        else if( num >= MILLION ) {
            helper(num / MILLION, builder);
            builder.append("Million ");
            helper(num % MILLION, builder);
        }
        else if( num >= 1000 ) {
            helper(num / 1000, builder);
            builder.append("Thousand ");
            helper(num % 1000, builder);
        }
        else if( num >= 100 ) {
            helper(num / 100, builder);
            builder.append("Hundred ");
            helper(num % 100, builder);
        }
        else if( num >= 20 ) {
            builder.append( LESS_THAN_100[num / 10] ).append(" ");
            helper(num % 10, builder);
        }
        else {
            builder.append( LESS_THAN_10[num] ).append(" ");
        }
    }
}
