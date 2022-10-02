class Solution {
    // 本题需要完全遍历多叉树，不考虑剪枝
    private List<String> result = new ArrayList<>();
    String[] dict = {"","","abc","def","ghi",
                     "jkl","mno","pqrs","tuv","wxyz"};
    private void backtracking(String digits,int index,StringBuffer path){
        if (path.length() == digits.length()){
            result.add(path.toString());
            return;
        }   
        for (int i = 0 ; i < dict[digits.charAt(index)-'0'].length() ; i++){
            path.append(dict[digits.charAt(index)-'0'].charAt(i));
            backtracking(digits,index+1,path);
            path.deleteCharAt(path.length()-1);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return result;
        }
        StringBuffer path = new StringBuffer();
        backtracking(digits,0,path);
        return result;
    }
}