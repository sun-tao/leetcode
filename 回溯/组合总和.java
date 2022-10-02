class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    // 未剪枝版本
    // private void backtracking(int[] candidates,int target,List<Integer> path,int sum,int startIndex){
    //     if (sum == target){
    //         result.add(new ArrayList<>(path));
    //         return;
    //     }
    //     if (sum > target){
    //         return;
    //     }
    //     for (int i = startIndex ; i < candidates.length ; i++){
    //         path.add(candidates[i]);
    //         sum += candidates[i];
    //         backtracking(candidates,target,path,sum,i);
    //         path.remove(path.size()-1);
    //         sum -= candidates[i];
    //     }
    //     return;
    // }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<Integer> path = new ArrayList<>();
    //     backtracking(candidates,target,path,0,0);
    //     return result;
    // }

    // 剪枝版本
    private void backtracking(int[] candidates,int target,List<Integer> path,int sum,int startIndex){
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = startIndex ; i < candidates.length && sum + candidates[i] <= target ; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates,target,path,sum,i);
            path.remove(path.size()-1);
            sum -= candidates[i];
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtracking(candidates,target,path,0,0);
        return result;
    }
}