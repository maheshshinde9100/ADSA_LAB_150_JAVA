package DivideAndConquer;

import java.util.Arrays;
/*test case:
    input : [3,2,5,6,1]   k=2
    output: 5
*/
public class KthLargestElementInArray_04 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,6,1};
        int k = 2;
        System.out.println(getKthLargestElement(arr,k));
    }
    static int getKthLargestElement(int[] arr,int k){
        int[] res = mergeSort(arr);
        int correctIndex = res.length-k;
//        if(k<arr.length && res[correctIndex] == res[correctIndex+1]){
//            return res[correctIndex-1];       //if 2 duplicates found consecutive
//        }
        return res[correctIndex];
    }
    private static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(arr,left,right);
    }
    private static int[] merge(int[] arr,int[] left,int[] right){
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }
}
