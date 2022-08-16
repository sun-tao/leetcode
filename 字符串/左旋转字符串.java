import static java.lang.System.out;
class Solution {
    public String reverseLeftWords(String s, int n) {
        // 新开空间
        // StringBuffer result = new StringBuffer();
        // StringBuffer sb1  = new StringBuffer(s.substring(0,n));
        // StringBuffer sb2 = new StringBuffer(s.substring(n,s.length()));
        // result.append(sb2);
        // result.append(sb1);
        // return result.toString();

        // 原地修改，两次反转即可
        char[] initArr = s.toCharArray();
        //左闭右闭区间反转
        reverse(initArr,0,initArr.length-1);
        reverse(initArr,0,initArr.length-n-1);
        reverse(initArr,initArr.length-n,initArr.length-1);
        return new String(initArr,0,initArr.length);
    }   
    private void reverse(char[] s , int start ,int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return;
    } 
}