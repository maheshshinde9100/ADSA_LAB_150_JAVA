import java.util.Scanner;

public class Assignment_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N  :> ");
        int n = sc.nextInt();
//        int n = 10;
//        System.out.println(findFactorial(n));
        System.out.println(findFactorial2(n));
    }

    //brute force
    static int findFactorial(int n){
        int i=1;
        int fact = 1;
        while(true) {
            fact =fact*i;
            int count = getCount(fact, 0);
            if (count == n) {
                return i;
            }
            i = i + 1;
        }
    }
    static int getCount(int num,int count){
        if(num<10){
            if(num==0){
                return count+1;
            }
            return count;
        }
        int rem = num%10;
        if(rem==0){
            count++;
        }
        if(rem!=0){
            return count;
        }
        return getCount(num/10,count);
    }

    static int calculateFact(int num){
        int i = 1;
        int fact = 1;
        while(i<=num){
            fact = fact * i;
            i++;
        }
        return fact;
    }

    //divide and conquerr
    static int findFactorial2(int n) {
        int left = 0;
        int right = 5*n;
        int res = -1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
//            int fact = calculateFact(mid);
//            int count = getCount(fact,0);
            int count = getCount2(mid);
            if(count ==n) {
                res =mid;
                right = mid-1;
            } else {
                if(count<n) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return res;
    }

    static int getCount2(int num)
    {
        int count=0;
        while(num >0){
            num = num/5;
            count =count+num;
        }

        return count;
    }
}
