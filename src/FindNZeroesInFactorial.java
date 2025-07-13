public class FindNZeroesInFactorial {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(search(n));
    }
    static int search(int n){
        long fact = 1;
        int i = 1;
        while(true){
            fact = fact*i;
            if(getCount(fact,0) == n){
                System.out.println(fact);
                return i;
            }
            i++;
        }
    }

    static int getCount(long num,int count){
        if(num<10){
            if(num==0){
                count++;
            }
            return count;
        }
        int rem =(int) num%10;
        if(rem!=0){
            return count;
        }else{
            count++;
        }
        return getCount(num/10,count);
    }

}
