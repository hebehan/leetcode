package easy;

import com.alibaba.fastjson.JSON;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.List;

/**
 * 罗马数转整数
 * @author Hebe Han
 * @date 2018/5/17 19:16
 */
public class _013_罗马数字转整数_RomanToInteger {


//    罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
//
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//    给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
//    示例 1:
//
//    输入: "III"
//    输出: 3
//    示例 2:
//
//    输入: "IV"
//    输出: 4
//    示例 3:
//
//    输入: "IX"
//    输出: 9
//    示例 4:
//
//    输入: "LVIII"
//    输出: 58
//    解释: C = 100, L = 50, XXX = 30, III = 3.
//    示例 5:
//
//    输入: "MCMXCIV"
//    输出: 1994
//    解释: M = 1000, CM = 900, XC = 90, IV = 4.

    public static void main(String[] args) {
        romanToInt("IV");
    }

    /**
     * LeetCode解 54ms 思想差不多,用变量提前存前一个或者后一个数字
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I'://1
                    if (pre > 1) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    pre = 1;
                    break;
                case 'V'://5
                    if (pre > 5) {
                        result -= 5;
                    } else {
                        result += 5;
                    }
                    pre = 5;
                    break;
                case 'X'://10
                    if (pre > 10) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    pre = 10;
                    break;
                case 'L'://50
                    if (pre > 50) {
                        result -= 50;
                    } else {
                        result += 50;
                    }
                    pre = 50;
                    break;
                case 'C'://100
                    if (pre > 100) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    pre = 100;
                    break;
                case 'D'://500
                    if (pre > 500) {
                        result -= 500;
                    } else {
                        result += 500;
                    }
                    pre = 500;
                    break;
                case 'M'://1000
                    if (pre > 1000) {
                        result -= 1000;
                    } else {
                        result += 1000;
                    }
                    pre = 1000;
                    break;

            }
        }
        return result;
    }

    /**
     * 我的解 91ms
     * @param s
     * @return
     */
    public static int mysolution(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (String.valueOf(chars[i])){
                case "I":
                    list.add(1);
                    break;

                case "V":
                    list.add(5);
                    break;

                case "X":
                    list.add(10);
                    break;

                case "L":
                    list.add(50);
                    break;

                case "C":
                    list.add(100);
                    break;

                case "D":
                    list.add(500);
                    break;

                case "M":
                    list.add(1000);
                    break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size()-1){
                if (list.get(i) < list.get(i+1)){
                    result-=list.get(i);
                }else {
                    result+=list.get(i);
                }
            }else {
                result+=list.get(i);
            }

        }
        return result;
    }


}
