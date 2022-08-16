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

import static java.lang.System.out; 
class Solution {
    public String reverseWords(String s) {
        // 原地修改，先整体反转，再隔单词反转，二次反转
        char [] initArr = s.toCharArray();
        reverse(initArr,0,initArr.length-1);
        int k = 0;
        for (int i = 0 ; i < initArr.length ; i++){
            if (initArr[i] == ' '){
                continue;
            }
            int begin = i;
            while(i < initArr.length && initArr[i] != ' '){
                i++;
            }
            //找到空格
            //对单一的单词进行处理
            int end = i -1; //空格的前一个，即单词的末尾
            reverse(initArr,begin,end);
            // out.println(initArr);
            // out.println(k);
            for (int j = begin ; j <= end ; j++){
                initArr[k++] = initArr[j];
            }
            if (k < initArr.length){
                 initArr[k++] = ' ';
            }
        }
        return new String(initArr,0,k == initArr.length && initArr[k-1] != ' ' ? k : k-1);
    }

    private void reverse(char [] s , int start , int end){
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

