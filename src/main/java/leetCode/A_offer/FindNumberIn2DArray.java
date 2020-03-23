package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName FindNumberIn2DArray
 * @Description: 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 22:52
 */
public class FindNumberIn2DArray {
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        if (matrix.length==0)
//            return false;
//        //判断目标是否大于每组树的最小值，小于最大值。如果是就在这组里寻找
//        int length=matrix[0].length;
//        if (length==0)
//            return false;
//        for(int row=0;row<matrix.length;row++){
//            if(target>=matrix[row][0]&&target<=matrix[row][length-1]){
//                for (int line=0;line<matrix[row].length;line++){
//                    if (target==matrix[row][line])
//                return true;
//            }
//            }
//        }
//        return false;
//    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //因为这个二维数组的规律，行列可以设置为全局
        if (matrix.length==0)
            return  false;
        int row=0,line=matrix[row].length-1;
        if (line==0)
            return false;
        for (;line>=0&row<=matrix.length;) {
            if (row>=matrix.length||line<=0)
                return false;
            if (target>matrix[row][line])
                row++;
            if (target<matrix[row][line])
                line--;
            if (target==matrix[row][line])
                return true;
        }
        return false;
    }
}
