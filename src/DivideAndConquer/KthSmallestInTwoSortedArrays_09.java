package DivideAndConquer;
import java.util.*;
/*
* Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
* Output: 6
*/
public class KthSmallestInTwoSortedArrays_09 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,45};
        int[] arr2 = new int[]{4,6,7,8};
        int k = 4;
        System.out.println("Kth from Two sorted arrays :> "+binarySearch(arr1,arr2,k));
    }
    //brute force
    //time complexity :  O(k)
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int i=0;
        int j=0;
        int count=0;
        int kthElement = -1;

        while(i<arr1.size() && j<arr2.size()){
            if(count==k){
                return kthElement;
            }
            if(arr1.get(i)<arr2.get(j)){
                kthElement = arr1.get(i);
                i++;
            }else{
                kthElement = arr2.get(j);
                j++;
            }
            count++;
        }
        return kthElement;
    }

    //divide and conquer : O(log(min(n, m)))
    public static int binarySearch(int[] a, int[] b, int k) {
        // Ensure a is the smaller array to minimize binary search range
        if (a.length > b.length) {
            return binarySearch(b, a, k);
        }
        int n = a.length;
        int m = b.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int l1 = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int l2 = (cutB ==0) ? Integer.MIN_VALUE : b[cutB - 1];

            int r1 = (cutA == n) ? Integer.MAX_VALUE : a[cutA];
            int r2 = (cutB == m) ? Integer.MAX_VALUE : b[cutB];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return -1;
    }
}
