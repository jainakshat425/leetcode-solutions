class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        Map<String,Integer> list1Choices = new HashMap();
        
        for(int i=0; i<n1; i++)
            list1Choices.put(list1[i], i);
        
        int indSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList();
        
        for(int i=0; i<n2 && i <= indSum; i++) {
            String choice = list2[i];
            int j = list1Choices.getOrDefault(choice, -1);
            
            if( j == -1 ) continue;
            
            if( i+j < indSum ) {
                indSum = i+j;
                ans = new ArrayList(){{ add(choice); }};
            } 
            else if( i+j == indSum )
                ans.add( choice );
        }
        return ans.toArray(new String[ans.size()]);
    }
}
