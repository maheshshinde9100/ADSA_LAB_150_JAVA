package GreedyApproach;
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;   // Capacity

        int n = value.length;

        // store value/weight ratio with index
        double[][] ratio = new double[n][2];
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) value[i] / weight[i]; // ratio
            ratio[i][1] = i; // index
        }

        // sort by ratio descending
        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            int idx = (int) ratio[i][1];
            if (weight[idx] <= W) {
                maxValue += value[idx];
                W -= weight[idx];
            } else {
                maxValue += value[idx] * ((double) W / weight[idx]);
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
