package leetcode.cn.explore.datastructure.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * edited by AndersonKim
 * at 2019/2/12
 */
public class Solution {

    //动态数组就是arraylist

    /**************************************************数组相关**************************************************/
    //至少是其他数字两倍的最大数的下标：定位数组中的第一大以及第二大的数字即可
    public int dominantIndex1(int[] nums) {
        int max1=0;
        int max2=0;
        int index=0;
        //先找到最大的数字
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>max1){
                max1=nums[i];
                index=i;
            }
        }
        //再找到第二大的数字
        for (int i = 0; i <nums.length ; i++) {
            if(i!=index){
                if(nums[i]>max2){
                    max2=nums[i];
                }
            }
        }
        //ALERT 双重循环可以归并为一次
        //判断第一大的数和第二大的数关系是否至少是2倍关系
        if(max1>=(max2*2)){
            return index;
        }else{
            return -1;
        }
    }
    public int dominantIndex2(int[] nums) {
        int max1=0;
        int max2=0;
        int index=0;
        //SKILL 一次扫描中获取第一大以及第二大的数字
        for (int i = 0; i <nums.length ; i++) {
            //第二个if进入的条件是关键(nums[i]<=max1&&nums[i]>max2)
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                index=i;
            }else if(nums[i]>max2){
                max2=nums[i];
            }
        }

        //判断第一大的数和第二大的数关系是否至少是2倍关系
        return max1>=max2*2?index:-1;
    }


    //数组中心索引
    public int pivotIndex1(int[] nums) {
        //从左往右扫描，左半边和和右半边和
       int ls=0,rs=0;
       for(int i=0;i<nums.length;i++){
           //左半边的和
           if(i==0){
               ls=0;
           }else{
               ls+=nums[i-1];
           }
           //右半边的和
           rs=0;
           //ALERT 循环嵌套n^2时间复杂度
           for(int j=i+1;j<nums.length;j++){
               rs+=nums[j];
           }
           if(ls==rs){
               return i;
           }
       }
       return -1;
    }

    public int pivotIndex2(int[] nums) {
        //从左往右扫描，左半边和和右半边和
        int ls=0,rs=0,sum=0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=0;i<nums.length;i++){
            //左半边的和
            if(i==0){
                ls=0;
            }else{
                ls+=nums[i-1];
            }
            //SKILL 右半边的和可以不通过循环嵌套的方式获得
            rs=sum-ls-nums[i];

            if(ls==rs){
                return i;
            }
        }
        return -1;
    }

    public int[] plusOne1(int[] digits) {
        int num=Integer.parseInt(Arrays.toString(digits));
        num=num+1;
        String n= String.valueOf(num);
        int[] result=new int[n.toCharArray().length];
        for(char c:n.toCharArray()){

        }
        return new int[1];
    }



    /**************************************************二维数组相关**************************************************/

    @Test
    public void testDominantIndex(){
        Solution s= new Solution();
        int[] test={1,7,3,6,5,6};
        s.dominantIndex2(test);


        s.pivotIndex1(test);
    }

}
