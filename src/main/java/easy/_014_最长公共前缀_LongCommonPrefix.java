package easy;

/**
 * 最长公共前缀
 * @author Hebe Han
 * @date 2018/5/17 20:44
 */
public class _014_最长公共前缀_LongCommonPrefix {

//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//
//    示例 1:
//
//    输入: ["flower","flow","flight"]
//    输出: "fl"
//    示例 2:
//
//    输入: ["dog","racecar","car"]
//    输出: ""
//    解释: 输入不存在公共前缀。
//    说明:
//
//    所有输入只包含小写字母 a-z 。

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    /**
     * LeetCode 5ms
     * 利用while + indexof == 0 依次递减
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.compareTo("") == 0)
                    return "";
            }
        }
        return prefix;
    }

    /**
     * 我的解 10ms
     * @param strs
     * @return
     */
    public static String mysolution(String[] strs) {
        String common = "";
        String shortst = "";
        char pre='1';
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null || strs[i].length() == 0)
                return "";
            
            if (shortst == "")
                shortst = strs[i];
            
            if (shortst.length()> strs[i].length())
                shortst = strs[i];
        }
        for (int i = 0; i < shortst.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0)
                    pre = strs[j].toCharArray()[i];

                if (strs[j].toCharArray()[i] != pre){
                    return common;
                }

            }
            common+=pre;
        }
        return common;
    }

}
