public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();

        TrieNode curr = root;

        for (int i = 0; i < n; i++) {

            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr.children[index].countPrefix++;

            curr = curr.children[index];
        }
        curr.countWord++;
    }

    private TrieNode find(String key) {
        int n = key.length();

        TrieNode curr = root;

        for (int i = 0; i < n; i++) {

            int index = key.charAt(i) - 'a';

            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }

    public int countWordsEqualTo(String word) {
        TrieNode wordNode = find(word);
        return wordNode == null ? 0 : wordNode.countWord;
    }

    public int countWordsStartingWith(String word) {
        TrieNode wordNode = find(word);
        return wordNode == null ? 0 : wordNode.countPrefix;
    }

    public void erase(String word) {
        int n = word.length();

        TrieNode curr = root;

        for (int i = 0; i < n; i++) {

            int index = word.charAt(i) - 'a';

            curr.children[index].countPrefix--;

            curr = curr.children[index];
        }
        curr.countWord--;
    }

    public class TrieNode {
        private static final int N = 26;
        public TrieNode[] children;
        public int countWord;
        public int countPrefix;

        public TrieNode() {
            children = new TrieNode[N];
        }
    }
}
