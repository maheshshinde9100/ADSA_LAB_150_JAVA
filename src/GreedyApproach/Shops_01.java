package GreedyApproach;

import java.util.Arrays;
/*
Implement a problem of activity selection problem with K persons.
Statement: Given two arrays S[] and E[] of size N denoting starting and
closing time of the shops and an integer value K denoting the number
of people, the task is to find out the maximum number of shops they
can visit in total if they visit each shop optimally based on the following
conditions:
 -> A shop can be visited by only one person.
 -> person cannot visit another shop if its timing collides with it.
*/

public class Shops_01 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[] s = new int[]{2,4,3,7};
        int[] e = new int[]{5,6,9,7};
        //expected output is : 3

        int[][] shops = new int[n][2];
        for(int i=0;i<n;i++){
            shops[i][0] = s[i];
            shops[i][1] = e[i];
        }
        Arrays.sort(shops, (a,b) -> Integer.compare(a[1],b[1]));
        int[] personEndTime = new int[k];
        Arrays.fill(personEndTime,-1);
        int count = 0;
        for(int[] shop: shops){
            for(int j=0;j<k;j++){
                if(shop[0] >= personEndTime[j]){
                    personEndTime[j] = shop[1];
                    count++;
                    break;
                }
            }
        }

        System.out.println("MAX shops visited :> "+count);
    }
}
