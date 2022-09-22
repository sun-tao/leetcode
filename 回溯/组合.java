class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    private void backtracking(int n , int k, int startIndex){
        if (path.size() == k){
            result.add(new ArrayList(path));
            return;
        }
        // 加剪枝
        for (int i = startIndex ; i <= n+path.size()-k+1 ; i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
        return;
    }
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
}