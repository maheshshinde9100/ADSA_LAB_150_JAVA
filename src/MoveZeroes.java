import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        //place all zeroes at the end of the array
        int[] arr = new int[]{1, 0, 2, 0, 0, 0, 4, 5, 6, 7};
        //expected output :> [10,3,20,1,2,0,0,0]

//        sort(arr);
        moveZeroes(arr, 0);
    }

    public static void sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] == 0) {

                int index = start;
                while (index != end - 1) {
                    arr[index] = arr[index + 1];
                    index++;
                }
                arr[end] = 0;
                end--;
            } else {
                start++;
            }
        }
        System.out.println(Arrays.toString(arr)); //done but O(n^2)
        //[1, 2, 4, 5, 6, 6, 0, 0, 0, 0]
    }

    public static void moveZeroes(int[] nums, int count) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
    }

        System.out.println(Arrays.toString(nums));


    }
}
