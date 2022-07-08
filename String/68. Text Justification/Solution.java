class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList();
        int left = 0, curWidth = words[0].length();
        
        for(int right=1; right<=n; right++) {
            if( right != n ) {
                // +1 for space between prev word and curr word
                int newWidth = curWidth + 1 + words[right].length();
                
                if( newWidth <= maxWidth ) {
                    curWidth = newWidth;
                    continue;
                }
            }
           
            ans.add( justify(left, right, curWidth, maxWidth, words) );
            
            // Reset to find next sentence
            left = right;
            curWidth = right != n ? words[right].length() : 0;
        }
        return ans;
    }
    
    private String justify(int left, int right, int curWidth, int maxWidth, String[] words) {
        int n = words.length;
        int spacesLeft = maxWidth - curWidth;
        int noOfWords = right-left;
        int spacesBwWords = 0, extraSpaces = spacesLeft;

        if( noOfWords != 1 && right != n ) {
            spacesBwWords = spacesLeft / (noOfWords-1);
            extraSpaces = spacesLeft % (noOfWords-1);
        } 

        StringBuilder sentence = new StringBuilder();

        while( left < right-1 ) {
            
            sentence.append(words[left++]).append(" ");

            if( right == n ) continue;

            for(int i=0; i<spacesBwWords; i++)
                sentence.append(" ");

            if( extraSpaces > 0 ) {
                sentence.append(" ");
                extraSpaces--;
            }
        }
        sentence.append(words[left]);
        
        for(int i=0; i<extraSpaces; i++)
            sentence.append(" ");
        
        return sentence.toString();
    }
}
