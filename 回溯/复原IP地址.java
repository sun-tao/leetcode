import static java.lang.System.out;
class Solution {
    private List<String> result = new ArrayList<>();
    private void backtracking(char[] s,int startIndex,StringBuffer path,int nodeCount){
        if (nodeCount == 4){
            // IP地址形成
            // 此时检查s中还剩多少
            if (startIndex < s.length){
                // 还有剩余字符没有用到
                return;
            }
            else{
                // ok,校验字符的工作不在这边做
                StringBuffer tmp = new StringBuffer(path);
                tmp.deleteCharAt(tmp.length()-1);
                result.add(new String(tmp.toString()));
                return;
            }
        } 
        for (int i = startIndex ; i < startIndex + 3 && i < s.length ; i++){
            StringBuffer sb = new StringBuffer();
            sb = sb.append(s,startIndex,i - startIndex + 1);
            
            if (isVaild(sb)){
                path.append(sb);
                path.append(new StringBuffer("."));
                //out.println("pathbefore=" +path);
                nodeCount++;
                backtracking(s,i+1,path,nodeCount);
                path.delete(startIndex+nodeCount-1,startIndex+nodeCount+sb.length());
                //out.println("pathafter=" + path);
                nodeCount--;
            }
			else{
				break;
			}
        }
        return;
    }

    private boolean isVaild(StringBuffer sb){
        // 判断要加入path的字符串是否合法
        for (int i = 0 ; i < sb.length() ; i++){
            // 非法字符校验
            if (sb.charAt(i) < '0' || sb.charAt(i) > '9'){
                return false;
            }  
        }
        // 开头是0校验
        if (sb.charAt(0) == '0' && sb.length() != 1){
                return false;
        }
        // 大于255校验
        if (Integer.parseInt(sb.toString()) > 255){
            return false;
        }
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        StringBuffer sb = new StringBuffer();
        backtracking(s.toCharArray(),0,sb,0);
        return result;
    }
}