package util;

/**
 * 算法工具类
 * @author gzy
 * @date 2020-04-17
 */
public class AlgorithmUtil {
    /**
     * 二分查找法
     * 这里只考虑所传的nums进来的必须是已经排序好的情况才继续的定位
     * 使用二分查找法进行定位，判断每次的二分的值是否满足条件，若二分下标对应值大于target值，则判断其左边的相临值是否小于等于target，
     * 若是则返回相邻下标,若否则继续二分，若二分下标对应值小于target值，则相反。
     * 这里有一个优化点假设数组的长度非常的长，在某次的二分中已经逼近了想要的对应下标，
     * 但是不满足上述条件那么就需要多次二分判断才能回到这里附近并取得目标下标，故优化点为若有良好的算法能够获得到最小的间距以间距做为判断条件，
     * 直到逼近为止目标下标为止，然后采用遍历的方式继续查找到目标下标。
     * @param nums      需要查找的数组
     * @param target    需要定位的目标下标
     * @param left      二分的左下标(若为第一位则为0)
     * @param right     二分的右下标(若为最后一位则为nums.length())
     * @return          返回小于或等于(既最接近target)的目标下标，若返回-1则表示left或者right不合法，若返回-2则表示所传数组不合法
     */
    public static int position(int[] nums,int target,int left,int right){
        //判断所传入的left和right是否合法
        if(left<0||right>nums.length) return -1;
        if(nums[0]>target||(right<nums.length&&nums[right]<target)||(right==nums.length&&nums[right-1]<target))  return -2;
        //先二分一次
        int newPosition=(left+right)/2;
        if(nums[newPosition]>target){           //若是则走左边
            //判断其左边小一位的值是否满足条件
            if(nums[newPosition-1]<=target){     //若是返回下标
                return newPosition-1;
            }
            return position(nums,target,left,newPosition-1);    //继续二分
        }else if(nums[newPosition]<target){     //若是走右边
            //判断其右边小一位的值是否满足条件
            if(nums[newPosition+1]==target){     //若是返回下标
                return newPosition+1;
            }
            return position(nums,target,newPosition+1,right);
        }
        return newPosition;
    }
}
