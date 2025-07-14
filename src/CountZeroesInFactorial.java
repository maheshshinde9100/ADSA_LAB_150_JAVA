public class CountZeroesInFactorial {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(calculate(n));

    }
    static int calculate(int n){
        int i = 1;
        long fact = 1;
        while(true){
            fact = fact*i;
            if(getCount(fact,0)==n){
                return i;
            }
            i++;
        }
    }
    static boolean foundFirstZero=false;
    static int getCount(long num,int count){
        if(num<10){
            if(num==0){
                count++;
            }
            return count;
        }
        int rem =(int) num%10;
        if(rem==0){
            if(foundFirstZero){
                return count;
            }else{
                count++;
            }
        }
        return getCount(num/10,count);
    }
}
