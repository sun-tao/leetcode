import static java.lang.System.out; 
class Solution {
    public String reverseWords(String s) {
        // 去除多余空格
        StringBuffer sb = new StringBuffer(s);
        // 删开头空格
        int i = 0;
        while(i < sb.length()){
            if (sb.charAt(i) != ' '){
                break;
            }
            sb.deleteCharAt(i);
        }
        //删中间空格
        //注意：StringBuffer删掉元素后，自动长度缩短，后面的字符往前补
        for (i = 0 ; i < sb.length() ; i++){
            while (i >= 1 && i < sb.length() && sb.charAt(i-1) == ' ' && sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
            }
        }
        //删除末尾空格
        if (sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length()-1);
        }

        sb.reverse();
        int start = 0;
        StringBuffer result = new StringBuffer();
        for (i = 0 ; i < sb.length() ; i++){
            if (sb.charAt(i) == ' '){
                //注意：StringBuffer的subString函数是左闭右开的
                StringBuffer temp = new StringBuffer(sb.substring(start,i));
                temp.reverse();
                result.append(temp);
                result.append(' ');
                start = i+1;
            }
        }
        StringBuffer temp = new StringBuffer(sb.substring(start,sb.length()));
        temp.reverse();
        result.append(temp);
        return result.toString();
    }
}