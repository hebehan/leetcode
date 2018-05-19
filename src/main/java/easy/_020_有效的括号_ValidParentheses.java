package easy;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * 有效的括号
 * @author Hebe Han
 * @date 2018/5/18 11:47
 */
public class _020_有效的括号_ValidParentheses {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
//
//    示例 1:
//
//    输入: "()"
//    输出: true
//    示例 2:
//
//    输入: "()[]{}"
//    输出: true
//    示例 3:
//
//    输入: "(]"
//    输出: false
//    示例 4:
//
//    输入: "([)]"
//    输出: false
//    示例 5:
//
//    输入: "{[]}"
//    输出: true

    public static void main(String[] args) {
//        reduce(0,"()[]{}".toCharArray(),0);
//        reduce(0,"()[]".toCharArray(),0);
//        reduce(0,"()[]".toCharArray());
//        reduce(0,"((()))".toCharArray(),0);
//        reduce(0,"((()))[]{}".toCharArray(),0);
//        reduce(0,"(]".toCharArray(),0);

//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < 100; i++) {
//            builder.append("([{");
//        }
//        for (int i = 0; i < 100; i++) {
//            builder.append("}])");
//        }
//        System.out.println(mysolution(builder.toString()));

//        System.out.println(mysolution("(([]){})"));
//        System.out.println(isValid("(([]){})"));
        System.out.println(iscan("([[[]]])"));
    }

    /**
     * 魔性正则
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        s = s.replace("\"", "").replace("\"", "");
        String upi = "";
        if (s == upi | s == null) return true;
        System.out.println("\\(\\)|\\{}|\\[]");
        for (int i = 0; i < s.length(); i++) {
            upi += s.charAt(i);
            upi = upi.replaceAll("\\(\\)|\\{}|\\[]", "");
        }
        if (upi.length() != 0) {
            return false;
        }
        return true;
    }
//====================我的解法 未解出来===========================================
    static boolean isOK = false;
    public static boolean mysolution(String s) {
        if (s == null)
            return false;
        if (s.equals(""))
            return true;
        if (s.length()%2 !=0)
            return false;
        char[] chars = s.toCharArray();
        if (chars[chars.length-1]==40||chars[chars.length-1]==91||chars[chars.length-1]==123)
            return false;
        isOK = false;
        return reduce(0,chars,0);
    }

    public static boolean reduce(int i,char[] chars,int depth){
        if (i > chars.length-1)
            return false;

        char c = chars[i];
        if (c==40||c==91||c==123){
            System.out.println("进入-"+i+"be depth-"+depth+" char-"+c);
            depth = i;
            System.out.println("进入-"+i+"af depth-"+depth+" char-"+c);
            reduce(++i,chars,++depth);
        }

        if (c==41||c==93||c==125){
            System.out.println("返回-"+i+" depth-"+depth+" char-"+c);
            System.out.println("退出depth be-"+depth+chars[depth]);
           depth =  depth==0?0:--depth;
            System.out.println("退出depth af-"+depth+chars[depth]);
            if (!isOk(c,chars[depth])){
                System.out.println("fuck you");
                isOK = false;
                return isOK;
            }else {
                isOK = true;
                System.out.println(chars[depth]+""+c);
            }
            if (chars.length>i){
                reduce(++i,chars,depth);
            }
        }
        return isOK;
    }

    public static boolean isOk(char big,char small){
        if (big == 41)
            return big-small==1;
        if (big == 93 || big == 125){
            return big - small == 2;
        }
        return false;
    }
//================================================================================


    /**
     * 网上找的11ms 利用倒序进出栈做的,每次把左括号添加到第一个,遇到右括号就判断第一个
     * @param s
     * @return
     */
    public static boolean isValidParentheses(String s) {
        // write your code here
        if (s.length() % 2 == 1) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        byte[] bytes = s.getBytes();
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                list.add(bytes[i]);
            } else {
                switch (bytes[i]){
                    case '{':
                        list.add(0,bytes[i]);
                        break;
                    case '[':
                        list.add(0,bytes[i]);
                        break;
                    case '(':
                        list.add(0,bytes[i]);
                        break;
                    case '}':
                        if (list.isEmpty()) {
                            return false;
                        }
                        if (list.get(0) == '{') {
                            list.remove(0);
                            break;
                        } else {
                            return false;
                        }
                    case ']':
                        if (list.isEmpty()) {
                            return false;
                        }
                        if (list.get(0) == '[') {
                            list.remove(0);
                            break;
                        } else {
                            return false;
                        }
                    case ')':
                        if (list.isEmpty()) {
                            return false;
                        }
                        if (list.get(0) == '(') {
                            list.remove(0);
                            break;
                        } else {
                            return false;
                        }
                }
            }
        }
        if (list.size() != 0) {
            return false;
        }
        return true;
    }

    //=============================这个还是不行============

    public static boolean iscan(String s){
        int x = 0;
        int y = 0;
        int z = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case '(':
                    x++;
                    break;
                case '[':
                    y++;
                    break;
                case '{':
                    z++;
                    break;
                case ')':
                    x--;
                    if (x<0)
                        return false;
                    break;
                case ']':
                    y--;
                    if (y<0)
                        return false;
                    break;
                case '}':
                    z--;
                    if (z<0)
                        return false;
                    break;
            }
        }
        return x==0&&z==0&&y==0;
    }
}
