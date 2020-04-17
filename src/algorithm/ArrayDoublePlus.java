package algorithm;

import util.AlgorithmUtil;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author gzy
 * @date 2020-04-17
 */
public class ArrayDoublePlus {
    /**
     * 解题思路：
     * 先把传入的数组进行从小到大排序，接着再取出数组下标的第一位，用target减去第一位得到新target，
     * 并使用二分查找法定位到一个大概的范围（该范围必须是定位值等于或大于新target值，左边值小于新target值），
     * 然后定位到的位置从右向左遍历是否和原target值是否相同，若相同则返回对应下标。
     * @param nums  原始数组
     * @param target    目标值
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        for(int j=0;j<nums.length-1;j++){
            arr[0]=j;
            //假定给的数组是有序的
            if(nums[j]>=target){
                return null;
            }

            //使用二分查找找到一个大概的范围
            final int newTarget=target-nums[j];  //固定出新的目标值
            int position= AlgorithmUtil.position(nums,newTarget,1,nums.length);
            if(position==-1||position==-2)  continue;
            for(int i=position;i>j;i--){
                if(nums[i]==newTarget){
                    arr[1]=i;
                    return arr;
                }
            }
        }

        return null;    //表示没有可以组合的项
    }
}
