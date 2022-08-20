import static java.lang.System.out;
class Solution {
    class MyDeque{
        // Deque继承自Queue，Queue是标准的队列接口，Deque是双端队列接口
        Deque<Integer> que;
        MyDeque(){
            que = new ArrayDeque<>();
        }
        void push(int x){
            while(!que.isEmpty() && que.peekLast() < x){
                que.pollLast();
            }
            que.offerLast(x);
        }
        void pop(int x){ // 实际应该出队的元素
            if (x == peek()){
                que.pollFirst();    // == que.poll()
            }
            return; 
        }
        int peek(){
            return que.peekFirst();
        } 
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 需要实现一个单调队列
        // 使用ArrayDeque这一双端队列来实现自己的这个单调队列
        int [] result = new int[nums.length-k+1];
        int maxNum = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0 ; i < k ; i++){
            if (nums[i] > maxNum){
                maxNum = nums[i];
                index = i;
            }
        }
        MyDeque md = new MyDeque();
        for (int i = index ; i < nums.length ; i++){
            if (i < k){
                md.push(nums[i]);
                continue;
            }
            result[i-k] = md.peek();
            md.pop(nums[i-k]);
            md.push(nums[i]);
        }
        result[nums.length - k] = md.peek();
        return result;
    }
}