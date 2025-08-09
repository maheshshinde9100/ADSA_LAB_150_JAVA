package DivideAndConquer;
import java.util.Arrays;
public class CountInversion_11 {

    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count +=mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid+1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i=0, j=0, k=left, swaps=0;

        while (i<leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (leftArr.length-i);
            }
        }

        while(i<leftArr.length) arr[k++]=leftArr[i++];
        while(j<rightArr.length) arr[k++]=rightArr[j++];

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Inversion Count: " + countInversions(arr));
    }
}

