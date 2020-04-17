package test;

import org.junit.Test;
import util.AlgorithmUtil;

public class AlgorithmUtilTest {
    //测试二分法
    @Test
    public void testPosition(){
        int nums[]=new int[]{2, 7, 11, 15};
        System.out.println("测试数组中所要查找的是10："+ AlgorithmUtil.position(nums,10,0,nums.length));
        System.out.println("测试数组中所要查找的是11："+AlgorithmUtil.position(nums,11,0,nums.length));
        System.out.println("测试数组中所要查找的是12："+AlgorithmUtil.position(nums,12,0,nums.length));
    }
}
