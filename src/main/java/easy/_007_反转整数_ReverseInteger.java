package easy;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 反转整数
 * @author Hebe Han
 * @date 2018/5/17 15:35
 */
public class _007_反转整数_ReverseInteger {

//    给定一个 32 位有符号整数，将整数中的数字进行反转。
//
//    示例 1:
//
//    输入: 123
//    输出: 321
//    示例 2:
//
//    输入: -123
//    输出: -321
//    示例 3:
//
//    输入: 120
//    输出: 21
//    注意:
//
//    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        reverse(-2147483648);
    }

    /**
     * 优化解 28ms
     * 思路 使用除以10加余数进行换位
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean flag = x>0;
        if (!flag) x = -x;
        long r = 0;
        while (x > 0){
            r = r*10 + x%10;
            x=x/10;
        }
        if (!flag)r=-r;
        if (r>Integer.MAX_VALUE || r<Integer.MIN_VALUE) return 0;
        return (int) r;
    }

    /**
     * 我的解   41ms
     * @param x
     * @return
     */
    public static int mysolution(int x){
        String intstr = x+"";
        int  k= 0;
        if (x<0){
            k=1;
        }
        char[] chars = intstr.toCharArray();

        for (int i=k; i < (chars.length-k)/2+k; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[chars.length-1-i+k];
            chars[chars.length-1-i+k] = temp;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            buffer.append(chars[i]);
        }
        Long result = Long.valueOf(buffer.toString());
        System.out.println(result);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return result.intValue();
    }
}
