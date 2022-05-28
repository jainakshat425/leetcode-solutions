import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		Set<String> dict = new HashSet(dictionary);
        ArrayList<String> ans = new ArrayList();
        wordBreak(0, new StringBuilder(), s, dict, ans);
        return ans;
	}
    
    private static void wordBreak(int start, StringBuilder curr, String s, Set<String> dict, 
                                  ArrayList<String> ans) {
        int n = s.length();
        if( start == n ) {
            ans.add( curr.toString() );
            return;
        }
        
        for(int end=start; end<n; end++) {
            String word = s.substring(start,end+1);
            if( dict.contains( word ) ) {
                int len = curr.length();
                if( len != 0 )
                    curr.append(" ");
                curr.append(word);
                
                wordBreak(end+1, curr, s, dict, ans);
                
                curr.delete(len, len+end+1);
            }
        }
    }
}
