import static java.lang.System.out;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int k , int n , int startIndex ,int sum){
        if (path.size() == k){
            if (sum == n){
                result.add(new ArrayList(path));
                return;
            }
            else{
               return; 
            }
        }
        // 从所需元素的个数上和sum上进行双重剪枝
        for (int i = startIndex; i <= 10 + path.size() - k && sum < n; i++){
            //out.println(path);
            path.add(i);
            sum += i;
            backtracking(k,n,i+1,sum);
            path.remove(path.size()-1);
            sum -= i;
        }
        return;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return result;
    }
}