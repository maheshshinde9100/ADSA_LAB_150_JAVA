import java.util.*;
public class Assignment_01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        boolean foundZero = false;
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            if(temp!= 0 && temp != 1){
                System.out.println("enter zeroes or ones");
                return;
            }
            if(foundZero && temp==1) {
                System.out.println("invalid input");
                return;
            }
            if(temp==0){
                foundZero = true;
            }
            arr[i] = temp;
        }

        boolean allZero = true;
        boolean allOne = true;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                allZero =false;
            }
            if(arr[i]!= 1){
                allOne = false;
            }
        }
        if(allZero || allOne) {
            System.out.println("invalid input");
            return;
        }
        System.out.println("Count of zero -> "+countZeroes(arr));
    }

    static int countZeroes(int[] arr){
        int start = 0;
        int end =arr.length-1;

        int f = -1;
        while(start <= end)
        {
            int mid = start +(end-start)/2;
            if(arr[mid] == 0)
            {
                f = mid;
                end = mid-1;

               /* if(arr[mid-1]==0){
                    int index = mid;
                  ]
                    while(arr[index]!=1){
                        count++;
                        index--;
                    }
                }
                */
            }
            else{
                start = mid+ 1;
            }
        }

        if(f==-1){
            return 0;
        }
        return arr.length-f;
    }
}

