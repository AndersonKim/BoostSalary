package leetcode.cn.explore.datastructure.string;

import org.junit.Test;

/**
 * edited by AndersonKim
 * at 2019/2/12
 */
public class Solution {
    //字符串比较不适用==
    //java中的==是比较两个对象的是否一致，equal才是字符串的比较函数
    //字符串不可变。建议char[]以及StringBuilder构建变化字符串


    public String addBinary1(String a, String b) {

        return a;
    }
    //String.indexOf()函数同样的功能
    public int strStr1(String haystack, String needle) {
        int i=0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                //i重新开始的下标是减去已匹配的长度字符串长度(i-j)的下一位(+1)
                i=i-j+1;
                j=0;
            }
        }
        //
        if(j==needle.length()){
            //i最后停下的下标一定包含子字串的长度
            return i-needle.length();
        }else{
            return -1;
        }

    }
    @Test
    public void testDominantIndex(){
        Solution s=new Solution();
        String a="hello",b="ll";
        //String a="a",b="a";
        s.strStr1(a,b);
    }
}
