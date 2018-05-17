package easy;

/**
 * 回文数
 * @author Hebe Han
 * @date 2018/5/17 18:28
 */
public class 回文数_9_Palindrome {
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
