class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    // 需要去重,树层去重
    private void backtracking(int[] candidates,int target,int startIndex,int sum,List<Integer> path,
                               boolean[] used ){
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = startIndex ; i < candidates.length ; i++){
            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false){
                continue; // 去重
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates,target,i+1,sum,path,used);
            path.remove(path.size()-1);
            sum -= candidates[i];
            used[i] = false;
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0,path,used);
        return result;
    }
}