class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList(n);
        for(int i=1; i<=n; i++) {
            boolean divBy3 = i%3 == 0;
            boolean divBy5 = i%5 == 0;
            
            if( divBy3 && divBy5 )
                ans.add("FizzBuzz");
            else if( divBy3  )
                ans.add("Fizz");
            else if( divBy5 )
                ans.add("Buzz");
            else ans.add(i + "");
        }
        return ans;
    }
}
