import java.util.Queue;
import java.util.LinkedList;

class Solution {

    public static String completeString(int n, String[] a) {
        Trie prefixTrie = new Trie();

        for (String prefix: a) {
            prefixTrie.insert(prefix);
        }

        return prefixTrie.longestCompleteString();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();

        TrieNode curr = root;

        for (int i = 0; i < n; i++) {

            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.word = word;
    }

    public String longestCompleteStringRecursive(TrieNode root, String word) {
        if (root == null) {
            return word;
        }
        String longest = word;

        for (TrieNode child: root.children) {
            if (child != null && child.isWord()) {

                String currWord = longestCompleteStringRecursive(child, child.word);

                if (currWord.length() > longest.length()) {
                    longest = currWord;
                }
            }
        }

        return longest;
    }

    public String longestCompleteString() {
        String longest = longestCompleteStringRecursive(root, "");
        return longest == "" ? "None" : longest;
    }

    /* Iterative (using Queues)
    public String longestCompleteString() {
    	String longest = "";
    	
    	Queue<TrieNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while( !queue.isEmpty() ) {
    		
    		TrieNode curr = queue.poll();
    		
    		for(TrieNode child : curr.children) {
    			if( child != null && child.isWord() ) {
    				queue.offer( child );
    				
    				if( child.word.length() > longest.length() ) {
    					longest = child.word;
    				}
    			}
    		}
    	}
    	return longest == "" ? "None" : longest;
    }
    */

    public class TrieNode {
        private static final int N = 26;
        public TrieNode[] children;
        public String word;

        public TrieNode() {
            children = new TrieNode[N];
        }

        public boolean isWord() {
            return word != null;
        }
    }
}
