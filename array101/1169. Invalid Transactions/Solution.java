class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Map<String,List<Transaction>> userTxns = new HashMap();
        boolean[] invalid = new boolean[n];
        List<String> ans = new ArrayList();
        
        for(int i=0; i<n; i++) {
            String[] txn = transactions[i].split(",");
            
            int time = Integer.parseInt(txn[1]);
            int amt = Integer.parseInt(txn[2]);
                
            userTxns.putIfAbsent(txn[0], new ArrayList());
            userTxns.get(txn[0]).add(new Transaction(i, time, amt, txn[3]));
        }
        
        for(String user : userTxns.keySet()) {
            List<Transaction> txns = userTxns.get(user);
            
            Collections.sort(txns, (a, b) -> Integer.compare(a.time, b.time));
            
            for(int i=0; i<txns.size(); i++) {
                
                Transaction txnI = txns.get(i);
                
                if( txnI.amount > 1000 )
                    invalid[txnI.index] = true;
                
                for(int j=i+1; j<txns.size(); j++) {
                    Transaction txnJ = txns.get(j);
                    
                    if( txnJ.time - txnI.time > 60 )
                        break;
                    
                    if( !txnJ.city.equals(txnI.city) ) {
                        invalid[txnJ.index] = true;
                        invalid[txnI.index] = true;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) 
            if( invalid[i] )
                ans.add( transactions[i] );
        
        return ans;
    }
    
    class Transaction { 
        public int index;
        public int time;
        public int amount;
        public String city;
        
        public Transaction(int index, int time, int amt, String city) {
            this.index = index;
            this.time = time;
            this.amount = amt;
            this.city = city;
        }
    }
}
