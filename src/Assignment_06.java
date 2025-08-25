import java.util.ArrayList;
import java.util.List;
public class Assignment_06 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 8, 12};
        List<Integer> profit = new ArrayList<>();
//        calculate(arr,profit,totalBuy);
        System.out.println("Max Profit :> " + calculateMaxProfit(arr));
    }

    //    static void calculate(int[] arr,List<Integer> profit, int totalBuy){
//        for(int i=1;i<arr.length;i++){
//            if(arr[i] > arr[i-1]){
//                profit.add(arr[i]-arr[i-1]);
//            }else{
//                totalBuy += arr[i];
//            }
//        }
//    }
    static int getMaxProfit(List<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            max = Math.max(arr.get(i), max);
        }
        return max;
    }


    static int calculateMaxProfit(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                maxProfit = maxProfit + arr[i] - arr[i - 1];
            }
        }
        return maxProfit;
    }
}
