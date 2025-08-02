package tasks;

/*find the contiguous subarray with larget sum (divide and conquer version)
input: [-2,1,-3,4,-1,2,1,-5,4]
output: 6 (sub-array [4,-1,2,1])
*/

public class MaximumSubArray_03 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(arr,0,arr.length-1));
    }
    static int maxSubArraySum(int[] arr,int left,int right){
        if(left==right){
            return arr[left];
        }
        int mid = (left+right)/2;

        int leftSum = maxSubArraySum(arr,left,mid);
        int rightSum = maxSubArraySum(arr,mid+1,right);
        int crossSum = maxCrossSum(arr,left,mid,right);
        return Math.max(Math.max(leftSum,rightSum),crossSum);
    }
    static int maxCrossSum(int[] arr,int left,int mid,int right){
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            sum+=arr[i];
            if(sum>leftMax){
                leftMax = sum;
            }
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++) {
            sum += arr[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }
        return leftMax + rightMax;
    }
}
