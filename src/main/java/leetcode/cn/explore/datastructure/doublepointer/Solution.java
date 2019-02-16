package leetcode.cn.explore.datastructure.doublepointer;

import org.junit.Test;

public class Solution {
    //反转字符串
    public void reverseString1(char[] s) {
        int start=0,end=s.length-1;
        while(start<end){
            char temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }

    //移除元素
    public int removeElement1(int[] nums, int val) {
        int k = 0;
        //快慢指针，i一定比k增加的快，所以可以将已经遍历过的位置用来存储数据。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    //最大连续1的个数
    public int findMaxConsecutiveOnes(int[] nums) {
        int time=0;
        int max=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                time++;
            }else{
                //当有多个含有1的区域的时候，保留最大的出现次数
                if(time>max){
                    max=time;
                }
                time=0;
            }
        }
        //当只有一个区域的1的时候获得最大值的方式
        if(time>max){
            max=time;
        }

        return max;
    }

    @Test
    public void testReverseString(){
        Solution s=new Solution();

        char[] chars={'a','s','w','q'};

        s.reverseString1(chars);

        int[] a={0,1};
        s.findMaxConsecutiveOnes(a);
    }

}
