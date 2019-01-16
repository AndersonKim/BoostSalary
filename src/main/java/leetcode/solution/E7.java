package leetcode.solution;

import org.junit.Test;

import static java.lang.Math.abs;

/**
 * edited by AndersonKim
 * at 2019/1/16
 * 注意数值的边界检查
 */
public class E7 {

    //错误的，因为反转的是二进制的数字而不是原来的数字
    public int reverse1(int x) {
        return Integer.reverse(x);
    }


    public int reverse2(int x){
        int res = 0;

        while (x != 0) {
            //防止出现10009反转后90001溢出的问题
            //int的范围如下： -2147483648～2147483647
            if (abs(res) > Integer.MAX_VALUE / 10)
                return 0;
            //每次迭代的时候取剩余数字的个位，将迭代的结果*10
            res = res * 10 + x % 10;
            //剩余数字除以10
            x /= 10;
        }
        return res;
    }

    @Test
    public void testReverse1(){
        E7 e=new E7();
//        System.out.println(e.reverse1(Integer.MAX_VALUE));
//        System.out.println(e.reverse1(123));
//        System.out.println(e.reverse1(0));
//        System.out.println(e.reverse1(-Integer.MAX_VALUE));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}




