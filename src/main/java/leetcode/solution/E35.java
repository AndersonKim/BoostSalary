package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

public class E35 {
    /**
     * 输入数组和目标值，存在则返回位置，否则返回需要插入的位置
     * @param nums 数组
     * @param target 目标数字
     * @return 存在的位置或需要插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        //当前遍历的数字大于（target需要插入的位置）或等于（target在数组中的位置）目标值就可以返回位置
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void TestE35(){
        int[] nums={1,3,5,6};
        int target=5;
        Assert.assertEquals(2,searchInsert(nums,target));
    }
}
