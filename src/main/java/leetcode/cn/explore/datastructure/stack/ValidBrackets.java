package leetcode.cn.explore.datastructure.stack;

import java.util.Stack;

/**
 * edited by AndersonKim
 * at 2019/2/12
 */
public class ValidBrackets {
    public boolean isValid1(String s) {
        Stack<Character> stack=new Stack<Character>();
        if(s.isEmpty()){
            return true;
        }else{
            char[] brackets=s.toCharArray();
            //依次入栈，数组中的左相的入栈，右相的和栈顶元素匹配成功后出栈否则不出栈。
            for(int i=0;i<brackets.length;i++){
                if (brackets[i]=='('||brackets[i]=='{'||brackets[i]=='['){
                    stack.push(brackets[i]);
                }else{
                    char popChar = stack.peek();
                    switch (popChar){
                        case '(':
                            if(brackets[i]==')')stack.pop();
                            break;
                        case '[':
                            if(brackets[i]==']')stack.pop();
                            break;
                        case '{':
                            if(brackets[i]=='}')stack.pop();
                            break;
                    }
                }
            }
            if(stack.empty()){
                return true;
            }else{
                return false;
            }
        }

    }

    public boolean isValid2(String s) {

        if(s.isEmpty())return true;
        Stack<Character> stack=new Stack<Character>();
        //入栈的时候就将其转换为对应的反向括号，出栈的时候直接比对是否一致即可
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args){
        ValidBrackets v=new ValidBrackets();
        v.isValid1("(]");
    }
}
