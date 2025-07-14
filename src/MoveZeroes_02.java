import java.util.Arrays;

public class MoveZeroes_02 {
    public static void main(String[] args) {
        //place all zeroes at the end of the array
        int[] arr = new int[]{1, 0, 2, 0, 0, 0, 4, 5, 6, 7};
        //expected output :> [10,3,20,1,2,0,0,0]

        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr) {

        if(arr.length ==1){
            return arr;
        }
       int mid = arr.length/2;

       int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
       int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

       return merge(arr,left,right);
    }

    static int[] merge(int[] arr,int[] left,int[] right)
    {
        int[] merged = new int[left.length +right.length];
        int i=0;
        int j =0;
        int k= 0 ;
        while(i<left.length && j<right.length) {
            if (left[i] > right[j]) {
                merged[k] = left[i];
                i++;

            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            merged[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length)
        {
            merged[k]=right[j];
            j++;
            k++;
        }
        return merged;
    }
}
