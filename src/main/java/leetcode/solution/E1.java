package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E1 {
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(nums.length);
        //1.将数字加入到map中
        //2.检查map中是否有能够构成target的值
        for(int pos=0;pos<nums.length;pos++){
            map.put(nums[pos],pos);
        }
        //bug:有相同的数字的时候无法返回正确的解答
        int[] result={-1,-1};
        for(int num:nums){
            if(map.containsKey(target-num)){
                result[0]=map.get(num);
                result[1]=map.get(target-num);
                return result;
            }
        }
        return result;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(nums.length);
        //1.将数字加入到map中
        //2.检查map中是否有能够构成target的值
        for(int pos=0;pos<nums.length;pos++){
            map.put(nums[pos],pos);
        }
        int[] result={-1,-1};
        for(int num:nums){
            int index1=map.get(num);
            //bug:相同的值不同的位置会出错
            int index2=map.get(target-num);
            //使用位置标记排除同一个位置的元素的情况
            if(map.containsKey(target-num)&&index1!=index2){
                result[0]=map.get(num);
                result[1]=map.get(target-num);
                return result;
            }
        }
        return result;
    }

    public int[] twoSum3(int[] nums, int target) {
        int len = nums.length;
        //key对应的值是当前位置上的数字需要达到target所需要的另一个数字即target-nums[i]
        //value对应的值是位置
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>(len);

        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int first = tracker.get(nums[i]);
                return new int[]{first+1, i+1};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
    @Test
    public void E1Test(){
        int[] nums1={3,2,4};
        int target1=6;
        System.out.println(Arrays.toString(twoSum1(nums1,target1)));

        int[] nums2={3,2,3};
        int target2=6;
        //System.out.println(Arrays.toString(twoSum2(nums2,target2)));

        int[] nums3={3,2,3};
        int target3=6;
        System.out.println(Arrays.toString(twoSum3(nums3,target3)));
    }
}
