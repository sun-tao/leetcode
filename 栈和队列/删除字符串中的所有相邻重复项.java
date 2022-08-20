class Solution {
    public String removeDuplicates(String s) {
        // 真的用栈来实现
        // Deque<Character> stack = new ArrayDeque<>();
        // for (int i = 0 ; i < s.length() ; i++){
        //     if (!stack.isEmpty() && stack.peek() == s.charAt(i)){
        //         stack.pop();
        //         continue;
        //     }
        //     stack.push(s.charAt(i));
        // }
        // StringBuffer sb = new StringBuffer();
        // while(!stack.isEmpty()){
        //     sb.append(stack.pop());
        // }
        // sb.reverse();
        // return sb.toString();

        // 用字符串模拟栈来实现
        // 这里字符串模拟栈并不是说在字符串原地修改，这样难度太大，可能需要回溯
        // 而是新开一个字符串空间，用它来模拟栈的行为

        StringBuffer sb = new StringBuffer();
        int top = -1;  // top 指向栈顶元素
        for (int i = 0 ; i < s.length() ; i++){
            if (top >= 0 && sb.charAt(top)== s.charAt(i)){
                sb.deleteCharAt(top);
                top--;
            }
            else{
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }
}