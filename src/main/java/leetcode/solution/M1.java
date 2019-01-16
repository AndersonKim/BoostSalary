package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

/**
 * edited by AndersonKim
 * at 2019/1/14
 */
public class M1 {
    public int[] twoSum1(int[] nums,int target){
        //1.put num into hashmap with num-pos
        // #0.use the  hashmap feature can get second num right away
        // #1.if use pos-num will hard to get second num position
        HashMap<Integer,Integer> numPosMap=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            numPosMap.put(nums[i],i);
        }
        //2.select first num and check if second num is in map
        int[] result={-1,-1};
        for(Integer pos:numPosMap.keySet()){
            int secondNum=target-pos;
            if(numPosMap.get(secondNum)!=null){
                result[0]=numPosMap.get(pos);
                //#1.if use pos-num will hard to get second num position
                result[1]=numPosMap.get(secondNum);
                break;
            }
        }
        //3.sort the result easy to read
        Arrays.sort(result);
        return result;
    }

    public int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> numPosMap=new HashMap<Integer, Integer>();
        int[] result={-1,-1};
        //the second loop could be added into the first one
        //because the secondenum can be got in other form
        for(int i=0;i<nums.length;i++){
            int secondNum=target-nums[i];
            if(numPosMap.get(secondNum)!=null){
                result[0]=i;
                result[1]=numPosMap.get(secondNum);
                break;
            }
            numPosMap.put(nums[i],i);
        }
        Arrays.sort(result);
        return result;
    }


    @Test
    public void testTwoSum1(){
        int[] num={2,3,5,4};
        int[] result=new M1().twoSum1(num,9);
        int[] right={2,3};
        assertEquals(right[0],result[0]);

    }
    @Test
    public void testTwoSum2(){
        int[] num={2,3,5,4};
        int[] result=new M1().twoSum1(num,9);
        int[] right={2,3};
        assertEquals(right[0],result[0]);
    }

}
