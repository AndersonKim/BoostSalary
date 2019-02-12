package leetcode.cn.explore.datastructure.stack;

import java.util.Stack;

/**
 * edited by AndersonKim
 * at 2019/2/12
 */
public class DailyTemp {

    public static  void main(String[] args){
        DailyTemp d=new DailyTemp();
        int[] temperatures ={73,74, 75, 71, 69, 72, 76, 73};
        d.dailyTemperatures(temperatures);
    }
    //TODO stack的作用？
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

}
