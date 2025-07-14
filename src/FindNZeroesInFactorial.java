public class FindNZeroesInFactorial {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(search(n));
    }
    static int search(int n){
//        long fact = 1;
//        int i = 1;
//        while(true){
//            fact = fact*i;
//            if(getCount(fact,0) == n){
//                System.out.println(fact);
//                return i;
//            }
//            i++;
//        }

        int start = 0;
        int end = 5*n;
        int result = -1;

        while (start <= end) {
            int mid = (start+end) / 2;
            int zeroCount = getCount2(mid);

            if(zeroCount == n) {
                result = mid;
                end = mid - 1;
            } else
                if(zeroCount < n){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

//    static int getCount(long num,int count){
//        if(num<10){
//            if(num==0){
//                count++;
//            }
//            return count;
//        }
//        int rem =(int) num%10;
//        if(rem!=0){
//            return count;
//        }else{
//            count++;
//        }
//        return getCount(num/10,count);
//    }

    static int getCount2(int num)
    {
        int count = 0;
        while(num > 0){
            num = num / 5;
            count =count+num;
        }
        return count;
    }
}
