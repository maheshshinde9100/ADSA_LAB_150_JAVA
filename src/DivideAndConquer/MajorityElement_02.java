package DivideAndConquer;

/*Find the element appearing more than [n/2] times using divide and conquer technique*/
public class MajorityElement_02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,1,2,3,2};
        System.out.println(majorityElement(arr,0,arr.length-1));
    }
    static int majorityElement(int[] arr,int left,int right){
        if(left==right){
            return arr[left];
        }
        int mid = (left+right)/2;
        int leftMajority = majorityElement(arr,left,mid);
        int rightMajority = majorityElement(arr,mid+1,right);

        if(leftMajority == rightMajority){
            return leftMajority;
        }

        int leftCount = countInRange(arr,leftMajority,left,right);
        int rightCount = countInRange(arr,rightMajority,left,right);
        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    static int countInRange(int[] arr,int num,int left,int right){
        int count= 0;
        for(int i=left;i<=right;i++){
            if(arr[i]==num){
                count++;
            }
        }
        return count;
    }
}
