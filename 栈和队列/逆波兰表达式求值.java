import static java.lang.System.out;
class Solution {
    private void printSt(Deque<Integer> st){
        while(!st.isEmpty()){
            out.println(st.pop());
        }
    }
    public int evalRPN(String[] tokens) {
        // 这题Java字符串浪费好久时间，Java字符串不能像C++那样直接用==比较，必须用equal()函数比较
        Deque<Integer> st = new ArrayDeque<>();
        String[] str = {"+","-","*","/"};
        HashSet<String> hs = new HashSet<>(Arrays.asList(str));
        for (int i = 0 ; i < tokens.length ; i++){
            //printSt(st);
            if (hs.contains(tokens[i])){
                // 是运算符
                int b = st.pop();
                int a = st.pop();
                int c;
                if ("+".equals(tokens[i])){
                    c = a + b;
                }
                else if ("-".equals(tokens[i])){
                    c = a - b;
                }
                else if ("*".equals(tokens[i])){
                    c = a * b;
                }
                else{
                    c = a / b;
                }
                st.push(c);
            }
            else{
                // 是数字
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}