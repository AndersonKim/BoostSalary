package practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 练习如何设计递归函数
 * https://www.cnblogs.com/Ponytai1/p/5950800.html
 */
public class Recursion {
    /**
     * 斐波那契数列的第n个数字是多少
     * @param n 数列中的第几个数字
     * @return
     */
    public int fibNum(int n){
        //1.定义出口：数列的第一个数字和第二个数字是1
        if (n<=2){
            return 1;
        //2.定义递推公式
        }else{
            return fibNum(n-1)+fibNum(n-2);
        }
    }
    @Test
    public void testFibNum(){
        Date st=new Date();
        for (int t=0;t<100000;t++){
            int sum=0,n=5;
            for(int i=0;i<n;i++){
                sum+=fibNum(n);
            }
            //System.out.println(sum);
        }
        Date et=new Date();
        System.out.println(et.getTime()-st.getTime());
    }
    /**
     * 斐波那契数列求解优化：空间换时间
     * @param n 第n个数字
     * @param arr 初始化为-1的数列
     * @return
     */
    public int fibNumModify(int n,int[] arr){
        //1.定义出口：数列的第一个数字和第二个数字是1
        if (n<=2){
            return 1;
            //2.定义递推公式
        }else{
            if(arr[n]!=-1){
                return arr[n];
            }else{
                arr[n]=fibNum(n-1)+fibNum(n-2);
                return arr[n];
            }
        }
    }

    @Test
    public void testFibModify(){
        Date st=new Date();
        for (int t=0;t<100000;t++){
            int sum=0,n=5;
            int[] arr=new int[n+1];
            Arrays.fill(arr,-1);
            for(int i=0;i<n;i++){
                sum+=fibNumModify(n,arr);
            }
            //System.out.println(sum);
        }
        Date et=new Date();
        System.out.println(et.getTime()-st.getTime());

    }

    /**
     * 小青蛙跳到第n级台阶有几种跳法，每次可以跳1~2级
     * @param n 台阶的第n级
     * @return
     */
    public int jump(int n){
        //1.定义出口：规模缩减到只有一级台阶
        if (n<=2){
            return n;
            //2.定义递推公式
        }else{
            return jump(n-1)+jump(n-2);
        }
    }

    @Test
    public void testJump(){
        int n=5;

        System.out.println(jump(n));
    }





}
