class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        Map<String,Integer> wordToChainLen = new HashMap();
        int ans = 0;
        
        for(String word : words) {
            int maxLen = 1;
            
            for(int deleteInd=0; deleteInd<word.length(); deleteInd++) {
                
                String newWord = deleteCharAt(word, deleteInd);
                maxLen = Math.max(maxLen, wordToChainLen.getOrDefault(newWord, 0) + 1);
            }
            
            wordToChainLen.put(word, maxLen);
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }
    
    private String deleteCharAt(String str, int ind) {
        return new StringBuilder(str).deleteCharAt(ind).toString();
    }
}
