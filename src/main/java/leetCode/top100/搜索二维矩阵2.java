package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 * @Author: YaYa
 * @Create: 2020-08-05 16:03
 */
public class 搜索二维矩阵2 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length==0||matrix[0].length==0) return false;
//        int mid =matrix.length/2;
//        for (int i = 0; i < matrix.length; i++) {
//            if (target<matrix[i][0]||target>matrix[i][matrix[i].length-1]){
//                continue;
//            }
//            if (binarySearch(matrix[i],target)) return true;
//        }
//        return false;
//    }
//
//    public boolean binarySearch(int[] nums,int target){
//        return helper(nums, 0, nums.length-1, target);
//    }
//
//    public boolean helper(int[] nums, int left,int right,int target){
//        if (left>right)
//            return false;
//        if (nums[(right+left)/2]==target){
//            return true;
//        }else if ((nums[(right+left)/2]<target)){
//            return helper(nums, (right+left)/2+1, right, target);
//        }else {
//            return helper(nums, left, (right+left)/2-1, target);
//        }
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length - 1, line = 0;
        while (row >= 0 && line < matrix[0].length) {
            if (matrix[row][line] == target)
                return true;
            else if (matrix[row][line] > target)
                row--;
            else if ((matrix[row])[line] < target)
                line++;
        }
        return false;
    }
}
