import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        //place all zeroes at the end of the array
        int[] arr = new int[]{1,0,2,0,0,0,4,5,6,7};
        //expected output :> [10,3,20,1,2,0,0,0]
        sort(arr);
    }
    public static void sort(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            if(arr[start]==0){

                int index = start;
                while(index!=end-1){
                    arr[index] = arr[index+1];
                    index++;
                }
                arr[end] = 0;
                end--;
            }else{
                start++;
            }
        }
        System.out.println(Arrays.toString(arr)); //done
        //[1, 2, 4, 5, 6, 6, 0, 0, 0, 0]
    }
}
