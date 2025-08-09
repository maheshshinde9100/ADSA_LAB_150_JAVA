package DivideAndConquer;
//Sorted rotated array - search element and return index if found otherwise return -1
public class SearchInRotatedSortedArray_08 {
    public static void main(String[] args) {
        int[] arr= new int[]{4,5,6,1,2,3};
        int target = 2;
        int index = search(arr,target);
        if(index!=-1){
            System.out.println("Found at index : "+index);
        }else{
            System.out.println("Not Found..!!!");
        }
    }
    static int search(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if(arr[left] <= arr[mid]) {
                if(arr[left] <= target && target < arr[mid]) {
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //checkingg for right part
            else{
                if(arr[mid]<target && target <= arr[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

        }

        return -1;
    }
}
