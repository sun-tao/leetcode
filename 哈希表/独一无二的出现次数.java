class Solution {
    public boolean uniqueOccurrences(int[] arr) {
		// 哈希表
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr.length ; i++){
            int temp = map.getOrDefault(arr[i],0);
            map.put(arr[i],temp+1);
        }
        Set<Map.Entry<Integer,Integer>> entrys = map.entrySet(); // 获得所有的映射
        for (Map.Entry<Integer,Integer> entry : entrys){
            if (set.contains(entry.getValue())){
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}