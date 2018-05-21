package sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 * @author Hebe Han
 * @date 2018/5/21 10:38
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] numbs = new int[]{3,1,4,8,7};
        bubblesort(numbs,1);
        System.out.println(JSON.toJSONString(numbs));
    }

    public static void  bubblesort(int[] numbs,int type){
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i; j < numbs.length; j++) {

                if (type==0){

//                    System.out.printf("i = %d, j = %d, numbs[i] = %d, numbs[j] = %d\n",i,j,numbs[i],numbs[j]);
                    //从小到大
                    if (numbs[j]<numbs[i]){
//                        System.out.printf("goin i = %d, j = %d, numbs[i] = %d, numbs[j] = %d\n",i,j,numbs[i],numbs[j]);
                        int tmp = numbs[i];
                        numbs[i] = numbs[j];
                        numbs[j] = tmp;
                    }
                }else {
                    //从大到小
                    if (numbs[j]>numbs[i]){
                        int tmp = numbs[i];
                        numbs[i] = numbs[j];
                        numbs[j] = tmp;
                    }
                }
            }
        }
//        System.out.println(JSON.toJSONString(numbs));
    }

}
