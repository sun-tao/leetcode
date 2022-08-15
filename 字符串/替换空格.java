import static java.lang.System.out;
class Solution {
    // 传统的字符串转字符数组解法
    // public String replaceSpace(String s) {
    //     char[] char_s = s.toCharArray();
    //     int count = 0;
    //     for (int i = 0 ; i < char_s.length ; i++){
    //         if (char_s[i] == ' '){
    //             count++;
    //         }
    //     }
    //     char [] result_s = new char[char_s.length + 2 * count];
    //     int cnt = 0;
    //     for (int i = 0 ; i < char_s.length ; i++){
    //         if (char_s[i] == ' '){
    //             result_s[cnt++] = '%';
    //             result_s[cnt++] = '2';
    //             result_s[cnt++] = '0'; 
    //             continue;
    //         }
    //         result_s[cnt++] = char_s[i];
    //     }
    //     String result = new String(result_s);
    //     return result;
    // }
    // 使用字符串的一些api
    public String replaceSpace(String s){
        if (s.length() == 0){
            return s;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}