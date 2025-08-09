package DivideAndConquer;

public class MinimumFromRotatedSortedArray_10 {
        public int findMin(int[] nums) {
            return binarySearch(nums,0,nums.length-1);
        }
        public int binarySearch(int[] arr,int low,int high){
            if(low == high){
                return arr[low];
            }
            int mid = low+(high-low)/2;

            if(arr[mid]>arr[high]){
                return binarySearch(arr,mid+1,high);
            }else{
                return binarySearch(arr,low,mid);
            }
        }
        public static void main(String[] args){
            MinimumFromRotatedSortedArray_10 obj = new MinimumFromRotatedSortedArray_10();
            int[] arr= new int[]{4,5,6,1,2,3};   //min : 1
            System.out.println("Min in Array :> "+obj.findMin(arr));
        }
    }
