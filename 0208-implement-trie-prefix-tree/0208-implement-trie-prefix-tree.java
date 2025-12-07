class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    //Insert a word to a trie
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            node = node.get(currentChar);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char currentChar = prefix.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            node = node.get(currentChar);
        }
        return true;
    }
}

class TrieNode{

    private TrieNode[] children;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
    }
    
    public boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node){
        children[ch - 'a'] = node;
    }

    public TrieNode get(char ch){
        return children[ch - 'a'];
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */