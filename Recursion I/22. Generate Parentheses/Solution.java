class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        generate(n, 0, new StringBuilder(), ans);
        return ans;
    }
    
    private void generate(int open, int close, StringBuilder str, List<String> ans) {
        if( open == 0 && close == 0 ) {
            ans.add( str.toString() );
            return;
        }
        
        if( open > 0 ) {
            str.append( '(' );
            generate(open-1, close+1, str, ans);
            str.deleteCharAt( str.length() - 1 );
        }
        
        if( close > 0 ) {
            str.append( ')' );
            generate(open, close-1, str, ans);
            str.deleteCharAt( str.length() - 1 );
        }
    }
}
