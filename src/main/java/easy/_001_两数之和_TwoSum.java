package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author Hebe Han
 * @date 2018/5/17 15:32
 */
public class _001_两数之和_TwoSum {

//    给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
//
//    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]


    public static void main(String[] args) {
        int ex[] = {1,2,3,4,5,6,7,8,9,10};
        twoSum(ex,17);
    }

    /**
     * 比较好的解 7ms
     * 思路 替换掉双层for循环,存储一次答案,循环后去存储的地方找
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;
        int sum[] = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else {
                sum[0] = i;
                sum[1] = map.get(target - nums[i]);
                return sum;
            }
        }
        return null;
    }

    /**
     * 我的解   33ms
     * @param nums
     * @param target
     * @return
     */
    public static int[] mysolution(int nums[],int target){
        int sum[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    sum[0] = i;
                    sum[1] = j;
                    return sum;
                }
            }
        }
        return sum;
    }
}
