package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName SpiralOrder
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-07 18:35
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0)
            return new int[0];
        //设置边界，撞墙则转向，
        int up=0,down=matrix.length-1,left=0,right=matrix[up].length-1;
        //存放结果的数组
        int[] result=new int[matrix.length*matrix[up].length];
        //结果数组标记
        int index=0;
        while (up<down||left<right){
            //先横向
            int upx=left;
            while (upx<=right&&up<=down)
                result[index++]=matrix[up][upx++];
            up++;
            //再纵向
            int righty=up;
            while (righty<=down&&left<=right)
                result[index++]=matrix[righty++][right];
            right--;
            //然后横向
            int downx=right;
            while (downx>=left&&up<=down)
                result[index++]=matrix[down][downx--];
            down--;
            //然后纵向
            int lefty=down;
            while (lefty>=up&&left<=right)
                result[index++]=matrix[lefty--][left];
            left++;
        }
        if ((matrix.length==matrix[0].length)&&(matrix.length&1)==1){
            result[result.length-1]=matrix[matrix.length>>1][matrix[0].length>>1];
        }
        return result;
    }
}
