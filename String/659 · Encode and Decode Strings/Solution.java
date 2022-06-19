public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str : strs) {
            builder.append(str.length());
            builder.append('#');
            builder.append(str);
        }
        return builder.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        int n = str.length();
        List<String> ans = new ArrayList();
        int i = 0;
        while( i < n ) {
            int j = i;

            while(str.charAt(j) != '#') 
                j++;
            
            // at index j, we've '#'
            int len = Integer.parseInt(str.substring(i,j));
            int start = j+1;
            int end = start + len;
            ans.add(str.substring( start, end ));
            i = end;
        }
        return ans;
    }
}
