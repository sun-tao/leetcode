import static java.lang.System.out;
class Trie {
    
    class TrieNode{
        boolean val; // 结点是否有效
        TrieNode[] children = new TrieNode[26];
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] cArray = word.toCharArray();
        TrieNode p = root;
        for (char c : cArray){
            int i = c - 'a';
            if (p.children[i] == null){
                // 开辟路径
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.val = true; // 到单词的尾部了，单词尾部的字符赋值true，代表一个单词结束
    }
    
    public boolean search(String word) {
        char [] cArray = word.toCharArray();
        TrieNode p = root;
        for (char c : cArray){
            int i = c - 'a';
            if (p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return p.val;
    }
    
    public boolean startsWith(String prefix) {
        char[] cArray = prefix.toCharArray();
        TrieNode p = root;
        for (char c : cArray){
            int i = c - 'a';
            if (p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return true;
    }
}