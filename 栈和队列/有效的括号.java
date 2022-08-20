class Solution {
    public boolean isValid(String s) {
        // ArrayDeque是双端队列，底层使用数组实现
        // 这题有个小技巧就是入栈的时候不要傻傻的直接把左括号入栈
        // 而是将其对应的右括号入栈，这样比较的时候就只要比较是否相等即可
		// ArrayDeque即可以当做栈来用，也可以当做队列来用
		// 当做栈和队列来用的时候，使用的api有些小区别
        Deque<Character> stack = new ArrayDeque<>();
        char [] chArr = s.toCharArray();
        for (int i = 0 ; i < chArr.length ; i++){
            if (chArr[i] == '(' || chArr[i] == '{' || chArr[i] == '['){
                stack.push(chArr[i]);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            char temp = stack.peek();
            stack.pop();
            if (chArr[i] == ')' && temp == '('){
                continue;
            }
            if (chArr[i] == ']' && temp == '['){
                continue;
            }
            if (chArr[i] == '}' && temp == '{'){
                continue;
            }
            return false;
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}