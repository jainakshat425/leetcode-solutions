class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> seen = new HashSet();
        
        for(String word : words) {
            StringBuilder builder = new StringBuilder();
            
            for(int i=0; i<word.length(); i++)
                builder.append(morseCode[word.charAt(i)-'a']);
            
            seen.add(builder.toString());
        }
        return seen.size();
    }
}
