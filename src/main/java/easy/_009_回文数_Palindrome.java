package easy;

/**
 * 回文数
 * @author Hebe Han
 * @date 2018/5/17 18:28
 */
public class _009_回文数_Palindrome {

//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//    示例 1:
//
//    输入: 121
//    输出: true
//    示例 2:
//
//    输入: -121
//    输出: false
//    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//    示例 3:
//
//    输入: 10
//    输出: false
//    解释: 从右向左读, 为 01 。因此它不是一个回文数。
//    进阶:
//
//    你能不将整数转为字符串来解决这个问题吗？


    public static void main(String[] args) {
        System.out.println(mysolution(11));
    }

    /**
     * 我的就是最优解..112ms 貌似时间比较看脸
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        return mysolution(x);
    }

    /**
     * 我的解 135ms
     * 参考了翻转整数的思路 翻转然后判断是否相等
     * @param x
     * @return
     */
    public static boolean mysolution(int x) {
        if (x<0)
            return false;
        int tem = x;
        int y=0;
        while (x>0){
            y = y*10+x%10;
            x=x/10;
        }
        return y==tem;
    }
}
