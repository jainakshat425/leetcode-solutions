
import java.util.ArrayList;

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		Trie trie = new Trie();
		
		int n = s.length();
		int count = 1;
		
		for(int i=0; i<n; i++) {
			count += trie.insertFrom(s, i);
		}
		return count;
	}
}
class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public int insertFrom(String word, int start) {
		int n = word.length();
		
		TrieNode curr = root;
		int charAddedCount = 0;
		
		for(int i=start; i<n; i++) {
			
			int index = word.charAt(i) - 'a';
			
			if( curr.children[index] == null ) {
				curr.children[index] = new TrieNode();
				charAddedCount++;
			}
			curr = curr.children[index];
		}
		return charAddedCount;
	}
	
	public class TrieNode {
		private static final int N = 26;
		public TrieNode[] children;
		
		public TrieNode() {
			children = new TrieNode[N];
		}
	}
}
