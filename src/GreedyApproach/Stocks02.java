package GreedyApproach;
import java.util.*;

public class Stocks02 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,7,8,9};
        List<Integer> profit = new ArrayList<>();
        int totalBuy = arr[0];
        calculate(arr,profit,totalBuy);
        System.out.println("Max Profit :> "+getMaxProfit(profit));
    }
    static void calculate(int[] arr,List<Integer> profit, int totalBuy){
        for(int i=1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                profit.add(arr[i]-arr[i-1]);
            }else{
                totalBuy += arr[i];
            }
        }
    }
    static int getMaxProfit(List<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++){
            max = Math.max(arr.get(i),max);
        }
        return max;
    }
}
