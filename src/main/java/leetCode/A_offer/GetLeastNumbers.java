package leetCode.A_offer;

import org.junit.Test;

/**
 * @Program: LeetCode
 * @ClassName GetLeastNumbers
 * @Description: 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-12 21:34
 */
public class GetLeastNumbers {
//    //先排序，再取前k个数
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k==0)
//            return new int[0];
//        if (k==arr.length)
//            return arr;
//        return helper(arr, k);
//    }
//    //排序算法
//    //使用选择排序
//    public int[] helper(int[] arr, int k){
//        for (int i = 0; i < k; i++) {
//            int temp=arr[i];
//            int index=i;
//            for (int j = i; j < arr.length; j++) {
//                if (temp>arr[j]){
//                    temp=arr[j];
//                    index=j;
//                }
//            }
//            if (index !=i) swap(arr,i, index);
//        }
//        return Arrays.copyOfRange(arr, 0, k);
//    }
//
//    public void swap(int[] nums,int i,int j){
//        nums[i]=(nums[i]+nums[j]);
//        nums[j]=nums[i]-nums[j];
//        nums[i]=nums[i]-nums[j];
//    }


    //方法二：使用快速排序
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr.length == 0) return arr;
//        return Arrays.copyOfRange(quick(arr, 0, arr.length - 1),0,k);
//    }
//
//    public int[] quick(int[] arr, int left, int right) {
//        if (left > right) return arr;
//        int tempLeft = left;
//        int tempRight = right;
//        int index = arr[left];
//        while (tempLeft < tempRight) {
//            while (arr[tempRight] >= index && tempRight > tempLeft) tempRight--;
//            while (arr[tempLeft] <= index && tempLeft < tempRight) tempLeft++;
//            if (tempLeft < tempRight)
//                swap(arr, tempLeft, tempRight);
//        }
//
//        arr[left]=arr[tempLeft];
//        arr[tempLeft]=index;
//
//        quick(arr, left, tempRight - 1);
//        quick(arr, tempRight + 1, right);
//        return arr;
//    }
//
    //交换两个数字
    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    //方法三：堆排序
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        if (k == arr.length) return arr;
        int heap[] = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        buildHeap(heap);
        for (int i = k; i < arr.length; i++) {
            if (heap[0] > arr[i]) {
                heap[0] = arr[i];
                tenanceHeap(heap, 0);
            }
        }
        return heap;
    }

    //建堆
    public void buildHeap(int[] heap) {
        if (heap.length == 0 || heap.length == 1) return;
        int lastNode = heap.length - 1;
        int leafNode = (lastNode - 1) >> 1;
        while (leafNode >= 0) {
            tenanceHeap(heap, leafNode--);
        }
    }

    //维护堆
    public void tenanceHeap(int[] heap, int curr) {
        int len = heap.length;
        if (curr > len) return;
        //左孩子
        int lc = (curr << 1) + 1;
        //右孩子
        int rc = (curr << 1) + 2;
        //零时存放值
        int temp = heap[curr];
        //最大标记
        int index = curr;
        if (lc < len && heap[lc] > temp) {
            temp = heap[lc];
            index = lc;
        }
        if (rc < len && heap[rc] > temp) {
            temp = heap[rc];
            index = rc;
        }
        if (curr != index) {
            swap(heap, index, curr);
            curr = index;
            tenanceHeap(heap, curr);
        }
    }


    @Test
    public void testDemo() {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        System.out.println(getLeastNumbers(arr, 5).toString());
    }
}
