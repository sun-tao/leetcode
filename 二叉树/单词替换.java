import static java.lang.System.out;
class Solution {
    class Trie{
        class TrieNode{
            boolean val;
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

        public String replace(String word){
            // 用单词的最短前缀去替换单词本身
            TrieNode p = root;
            StringBuffer res = new StringBuffer();
            for (char c : word.toCharArray()){
                int i = c - 'a';
                if (p.children[i] == null){
                    return word;  // 在前缀树中没有该单词的前缀
                }
                p = p.children[i];
                res.append(c);
                if (p.val){
                    return res.toString();
                }
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // 构造前缀树
        Trie tree = new Trie();
        for (int i = 0 ; i < dictionary.size() ; i++){
            tree.insert(dictionary.get(i));  // 对单个单词构造前缀树
        }
        // 前缀树构造完毕
        // 开始进行单词的替换
        char [] cArray = sentence.toCharArray();
        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for (int i = 0 ; i < cArray.length ; i++){
            //out.println(result);
            if (cArray[i] != ' '){
                sb.append(cArray[i]);
            }
            else{
                result.append(tree.replace(sb.toString()).toCharArray());
                result.append(' ');
                sb.delete(0,sb.length());
            }
        }
        //最后一个单词没有被访问到，这里手动添加一下
        result.append(tree.replace(sb.toString()).toCharArray());
        return result.toString();
    }
}