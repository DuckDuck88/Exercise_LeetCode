package leetCode.sort;

/**
 * @Program: LeetCode
 * @ClassName FirstBadVersion
 * @Description: 你是产品经理，目前正在带领一个团队开发新的产品。
 * 不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，
 * 所以错误的版本之后的所有版本都是错的。  假设你有 n 个版本 [1, 2, ..., n]，
 * 你想找出导致之后所有版本出错的第一个错误的版本。  你可以通过调用 bool isBadVersion(version) 接口来判断
 * 版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-26 16:49
 */
public class FirstBadVersion {
    //方法一：二分查找，找到为true并且左边不为true
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;

        while (left<right){
            int mid=left+(right-left)>>1;
            if (!isBadVersion(mid)){
                left=mid;
            }else {
                right=mid+1;
            }
        }
        return left;
    }
    public boolean isBadVersion(int i){return true;};
}
