package test;

import algorithm.ArrayDoublePlus;
import org.junit.Test;

public class ArrayDoublePlusTest {
    @Test
    public void test(){
        //第一种数组情况
//        int nums[]=new int[]{2, 7, 11, 15};
        //第二种数组情况，这种数据需要测试排序
        int nums[]=new int[]{0, 7, 11, 0};
        int arr[]= ArrayDoublePlus.twoSum(nums,0);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
