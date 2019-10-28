package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类为求N个数中有多少中组合成A的可能(排除重复项和0)
 * @author GZY
 * @date 2019-10-28
 */
public class SumAndNum {
    /**
     * 计算N个数中有多少中组合A的可能性(不含重复版)
     * @param N     个数
     * @param A     需求和数
     * 此方法可以自由配置，若需要返回也可以返回出具体的List为后续操作提供良好的衔接
     */
    public static void getSumANum(int N,int A){
        int arr[]=new int[N];
        List<int []> list=new ArrayList<>();
        //初始化
        for(int i=0;i<N;i++){
            arr[i]=1;
        }

        int deepNum=N-1,nowNum=N-1;
        while(true){
            if(deepNum<0) break;
            for(int j=0;j<A-1;j++){
                arr[N-1]=j+1;
                if(validateSumArr(arr,A)) {
                    int brr[]=arrayCopyAndAdjustment(N,arr);
                    if(!compareListArray(list,brr)){
                        list.add(brr);
                    }
                    break;
                }
            }
            if(arr[nowNum]==A-1||nowNum==N-1){
                if(nowNum!=deepNum){
                    for (int i=nowNum;i<N;i++){
                        arr[i]=1;
                    }
                    --nowNum;
                }else{
                    if(arr[deepNum]==A-1||deepNum==N-1) {
                        deepNum--;
                        arr[deepNum]=++arr[deepNum];
                        for (int i=deepNum+1;i<N;i++){
                            arr[i]=1;
                        }
                        nowNum=N-1;
                        continue;
                    }
                }
            }
            arr[nowNum]=++arr[nowNum];
            if(arr[0]==A-1) break;
        }

        if (list.size()==0){
            System.out.println(N+"个数中没有和为"+A+"结果集");
        }else{
            System.out.println("含有：");
            for(int brr[]:list){
                for(int i=0;i<N;i++){
                    if(i==0){
                        System.out.print(A+"="+brr[i]+"+");
                    }else if(i==brr.length-1){
                        System.out.println(brr[i]);
                    }else{
                        System.out.print(brr[i]+"+");
                    }
                }
            }
            System.out.println("在"+N+"个数的组合中能组合为"+A+"的个数有"+list.size()+"个！");
        }
    }

    /**
     * 数组的复制和调整，由于JAVA的特性不能直接赋值的形式故使用该方式
     * @param N     数组的初始大小
     * @param arr   需要复制和调整为从小到大的数组
     */
    private static int[] arrayCopyAndAdjustment(int N,int arr[]){
        int brr[]=new int[N];
        for(int i=0;i<N;i++){
            brr[i]=arr[i];
        }
        //使用一个最简单的冒泡排序
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(brr[i]>brr[j]){
                    int temp=brr[i];
                    brr[i]=brr[j];
                    brr[j]=temp;
                }
            }
        }

        return brr;
    }

    /**
     * 比较在list的数组中是否包含有相同的数组,包含返回true，否则为false
     * @param list  List集合池
     * @param arr   需比较数组
     * @return
     */
    private static boolean compareListArray(List<int []> list,int arr[]){
        for(int brr[]:list){
            boolean bo=true;
            for(int i=0;i<brr.length;i++){
                if(brr[i]!=arr[i]) {
                    bo=false;
                    break;
                }
            }
            if(bo) return true;
        }
        return false;
    }

    /**
     * 验证数组是否等于A，若相等返回true否则为false
     * @param arr
     * @param A
     * @return
     */
    private static boolean validateSumArr(int arr[],int A){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum==A){
//            for(int i=0;i<arr.length;i++){
//                if(i==0){
//                    System.out.print(A+"="+arr[i]+"+");
//                }else if(i==arr.length-1){
//                    System.out.println(arr[i]);
//                }else{
//                    System.out.print(arr[i]+"+");
//                }
//
//            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        getSumANum(3,6);
    }
}
