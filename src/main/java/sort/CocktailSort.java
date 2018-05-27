package sort;

import com.alibaba.fastjson.JSON;

/**
 * 鸡尾酒排序 冒泡改进
 * @author Hebe Han
 * @date 2018/5/21 16:52
 */
public class CocktailSort {

    public static void main(String[] args) {
        cocktailSort(new int[]{3,7,6,9,0,3,6,2,1});
    }

    public static void cocktailSort(int[] numbs){
        int left = 0;
        int right = numbs.length;
        while (right > left){

            for (int i = left; i < right; i++) {
//                System.out.println("left = "+left);
                int tmp = numbs[i];
                if (tmp< numbs[left]){
                    numbs[i] = numbs[left];
                    numbs[left] = tmp;
                }
            }
            right--;
            for (int i = right; i >left; i--) {
//                System.out.println("right = "+right);
                int tmp = numbs[i];
                if (tmp > numbs[right]){
                    numbs[i] = numbs[right];
                    numbs[right] = tmp;
                }
            }
            left++;
        }
//        System.out.println(JSON.toJSON(numbs));
    }
}
