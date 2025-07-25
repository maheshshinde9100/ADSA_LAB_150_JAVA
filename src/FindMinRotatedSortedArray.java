class FindMinRotatedSortedArray {
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
    FindMinRotatedSortedArray obj = new FindMinRotatedSortedArray();
    int[] arr= new int[]{4,5,6,1,2,3};   //min : 1
    System.out.println("Min in Array :> "+obj.findMin(arr));
  }
}
