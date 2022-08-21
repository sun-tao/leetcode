class Solution {
    class MyComp implements Comparator<Map.Entry<Integer,Integer>>{
        @Override
        public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2){
            return o1.getValue() - o2.getValue();
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // 优先级队列
        // hashmap统计频率

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        Set<Map.Entry<Integer,Integer>> entry = map.entrySet();  //map中的键值对
        // 优先级队列，队列中存放Entry键值对，并按照键值对中value的大小进行排序，从小到大排序
        // 除了lambda表达式，如何用接口的形式来制定比较规则？
        // 自定义类实现Comparator接口
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new MyComp());
        for (Map.Entry<Integer,Integer> e : entry){
            pq.offer(e);
            if (pq.size() > k){
                pq.poll();
            }
        } 

        int [] result = new int[k];
        int j = 0;
        while(!pq.isEmpty()){
            result[j++] = pq.poll().getKey();
        }
        return result;

    }
}