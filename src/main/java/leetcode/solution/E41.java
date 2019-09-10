package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E41 {
    /*
    无法满足以下测试用例
    Input: [7,8,9,11,12]
    Output: 1
    */
    public int firstMissingPositive1(int[] nums) {
        //1.排序
        //2.第一个缺失的正整数（不连续[从零开始后一个数比前一个数大1]，最大值+1）
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]!=nums[i]+1&&nums[i]>0){
                return nums[i]+1;
            }
        }
        return nums[nums.length-1]+1;

    }



    /**
     * 第一遍遍历数组把所有的数都存入HashSet中，并且找出数组的最大值，
     * 下次循环从1开始递增找数字，哪个数字找不到就返回哪个数字，如果一直找到了最大的数字(防止2的时候应返回1但是返回3)，则返回最大值+1
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        Set<Integer> numTable=new HashSet<Integer>();
        int max=0;
        for(int num:nums){
            numTable.add(num);
            if(max<num){
                max=num;
            }
        }
        for(int i=1;i<max;i++){
            if(!numTable.contains(i)){
                return i;
            }
        }
        return max+1;
    }
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    @Test
    public void TestE41() {
        //int[] nums={-1,0,1,2,4};
        int[] nums={3,4,-1,1};
        Assert.assertEquals(2,firstMissingPositive1(nums));
    }
}
