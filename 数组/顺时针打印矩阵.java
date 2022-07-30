//本题模拟相当复杂，最后有点耍赖的过了
//本题由于二维数组的长宽不限，因此很复杂，比原始的螺旋矩阵要难
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //模拟
        //坚持左闭右开原则
        if (matrix.length == 0){
            return new int[0];
        }
        int len = matrix[0].length;
        int width = matrix.length;
        int [] result = new int[len * width];

        int start_x = 0;
        int end_x   = len;
        int start_y = 0;
        int end_y = width;

        int cnt = 0;
        int index = 0;
        while(start_x <= end_x && start_y <= end_y){ //控制圈
            //一圈的逻辑
            
            for (int i = start_x ; i < end_x - 1 ; i++){
                result[cnt] = matrix[start_y][i];
                cnt++;
            }

            for (int i = start_y ; i < end_y - 1; i++){
                result[cnt] = matrix[i][end_x - 1];
                cnt++;
            }

            
            for (int i = end_x - 1 ; i > start_x ; i--){
                result[cnt] = matrix[end_y - 1][i];
                cnt++;
                if (cnt >= len * width){
                    return result;
                }
            }

            for(int i = end_y -1 ; i > start_y ; i--){
                result[cnt] = matrix[i][start_x];
                cnt++;
                if (cnt >= len * width){
                    return result;
                }
            }
            
            start_x++;
            start_y++;
            end_x--;
            end_y--;
        } 

        if (width == len && width % 2 == 1){
            result[cnt] = matrix[width/2][len/2];
        }

        return result;
    }
}