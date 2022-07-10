class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // String length, count of words, word length
        int n = s.length(), m = words.length, wordLen = words[0].length();
        // Size of a valid substring
        int validSize = m * wordLen;
        // Indices in s, from where valid substrings starts
        List<Integer> ans = new ArrayList();
        
        // Count of each word in words array
        Map<String,Integer> wordCount = new HashMap();
        for(String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        
        for(int i=0; i<wordLen; i++) 
            valid(i, n, m, wordLen, validSize, s, wordCount, ans);
        
        return ans;
    }
    
    private void valid(int left, int n, int m, int wordLen, int validSize, String str, Map<String,Integer> wordCount, List<Integer> ans) {
        
        Map<String,Integer> strCount = new HashMap();
        int wordsFound = 0;
        boolean excessWord = false;

        for(int right=left; right <= n-wordLen; right += wordLen) {
            
            String curWord = str.substring(right, right + wordLen);
            
            if( !wordCount.containsKey(curWord) ) {
                strCount.clear();
                wordsFound = 0;
                excessWord = false;
                left = right + wordLen;
            } else {
                while( right - left == validSize || excessWord ) {
                    String leftWord = str.substring(left, left+wordLen);
                    int leftWordCnt = strCount.get(leftWord);
                    
                    if( leftWordCnt > wordCount.get(leftWord) )
                        excessWord = false;
                    else 
                        wordsFound--;
                    
                    strCount.put(leftWord, leftWordCnt-1);
                    left = left+wordLen;
                }

                int newRightCnt = strCount.getOrDefault(curWord, 0) + 1;
                strCount.put(curWord, newRightCnt);
                                
                if( newRightCnt > wordCount.get(curWord) )
                    excessWord = true;
                else 
                    wordsFound++;

                if( wordsFound == m && !excessWord ) 
                    ans.add( left );
            }
        }
    }
}
// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         int n = s.length(), m = words.length, wordLen = words[0].length();
//         int validSize = m * wordLen;
//         List<Integer> ans = new ArrayList();
//         Map<String,Integer> wordCount = new HashMap();
        
//         for(String word : words)
//             wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        
//         for(int i=0; i+validSize<=n; i++) 
//             if( validSubstr(i, i+validSize, wordLen, s, wordCount) ) 
//                 ans.add(i);
//         
//         return ans;
//     }
    
//     private boolean validSubstr(int start, int end, int wordLen, String str, Map<String,Integer> wordCount) {
//         Map<String,Integer> strCount = new HashMap();
                
//         for(int left=start; left+wordLen<=end; left += wordLen) {
            
//             String curWord = str.substring(left, left+wordLen);
            
//             int reqCount = wordCount.getOrDefault(curWord, -1);
            
//             if( reqCount == -1 )
//                 return false;
            
//             int newCount = strCount.getOrDefault(curWord, 0) + 1;
            
//             if( newCount > reqCount )
//                 return false;
            
//             strCount.put(curWord, newCount);
//         }
//         return true;
//     }
// }
