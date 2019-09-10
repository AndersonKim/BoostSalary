package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E26 {
    public int removeDuplicates1(int[] nums) {
        //使用set判断当前数字是否存在，存在就加到新数组中，否则不加入新的数组中
        Set<Integer> numSet=new HashSet<>(nums.length);
        int[] result=new int[numSet.size()];
        int i=0;
        for(int n:nums){
            if(!numSet.contains(n)){
                result[i++]=n;
                numSet.add(n);
            }
        }
        return numSet.size();
    }

    public int removeDuplicates2(int[] nums) {
        /*
        * 1.返回修改后的数组的长度
        * 2.原来的数组被修改
        * */
        //当前的数组已经走到哪里的游标
        int i = 0;
        for (int n : nums){
            //2.1 数组中的第一个一定是不重复的
            //2.2 当前的数组是一个升序排序的数组所以当前的数字比游标数字大的时候就可以认为不是一个重复的数字
            if (i == 0 || n > nums[i-1]){
                nums[i++] = n;
            }
        }
        return i;
    }


    @Test
    public void E26Test(){
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
}
