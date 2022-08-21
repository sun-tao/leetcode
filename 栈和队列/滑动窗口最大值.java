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
        // 思路：使用单调队列来记录所有有可能成为最大值的元素，这一过程减少了队列要记录的元素数量，使得
        // 每次要出队一个元素的时候，若不是最大的元素出去可以什么都不干，若是最大元素出去则正好将其出队。
        // 解决了原本这样一个矛盾：出队的时候要按照实际元素顺序出队，然而查询的时候需要在队头返回最大值。
        // 如果不这样做(使得小元素提前出队)，那每轮如果遇到实际出队元素不是最大元素，则会发生不知道该将哪个
        // 出队，如果硬添加会使得队列中元素个数超过k。
        // 同时，按照单调递减的顺序记录，可以每轮以O(1)的复杂度得到当前窗口的最大值
        int [] result = new int[nums.length-k+1];
        int maxNum = Integer.MIN_VALUE;
        int index = 0;
        MyDeque md = new MyDeque();
        for (int i = 0 ; i < k ; i++){
            md.push(nums[i]);
        }
        for (int i = k ; i < nums.length ; i++){
            result[i-k] = md.peek();
            md.pop(nums[i-k]);
            md.push(nums[i]);
        }
        result[nums.length - k] = md.peek();
        return result;
    }
}