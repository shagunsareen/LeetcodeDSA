class TrieNode{
    TrieNode[] children;
    boolean isWord;

    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}
    
class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            if(node.children[curr - 'a'] == null){
                node.children[curr -'a'] = new TrieNode();
            }
            node = node.children[curr - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word){
       return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isWord; //reached last node or not 
        }

        char curr = word.charAt(index);

        if(curr != '.'){
            TrieNode children = node.children[curr - 'a'];
            return children == null ? false : dfs(word, index + 1, children);
        }

        //explore all 26 possibilities
        for(TrieNode child : node.children){
            if(child != null && dfs(word, index+1, child)){
                return true;
            }
        }

        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
