class Solution {
    class Trie{
        class TrieNode{
            // boolean val;
            int num = 0;  // 以该路径为前缀的单词数目,我们的目标就是找以某个路径为前缀的单词数目，大大简化的寻找的难度
            TrieNode[] children = new TrieNode[26];
        }
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode p = root;
            for (char c : word.toCharArray()){
                int i = c - 'a';
                if (p.children[i] == null){
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
                p.num += 1;
            }
            return;
        }
        public int getScore(String word){
            TrieNode p = root;
            int result = 0;
            for (char c : word.toCharArray()){
                int i = c - 'a';
                if (p.children[i] == null){
                    // 基本不可能走到这
                    return result;
                }
                p = p.children[i];
                result += p.num;
            }
            return result;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int result = 0;
        // 构建前缀树
        Trie tree = new Trie();
        for (int i = 0 ; i < words.length ; i++){
            tree.insert(words[i]);
        }
        int[] answer = new int[words.length];
        // 利用前缀树计算word[i]的每个非空前缀分数的总和
        for (int i = 0 ; i < words.length ; i++){
            answer[i] = tree.getScore(words[i]);
        }
        return answer;
    }
}