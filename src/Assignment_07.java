public class Assignment_07 {
    public static void main(String[] args) {
        int D = 18;
        int[] task = new int[]{9, 10, 12, 9};
        int sum = 0;

        for(int t:task) {
            sum += t;
        }

        float minHours = Float.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;

        for(int i=1;i<=D;i++){
            float hoursPerDay = getMinHours(sum, i);
            minHours = Math.min(minHours, hoursPerDay);

            int days = getMaxDays(sum,i);
            if(days<=D){
                maxDays = Math.max(maxDays, days);
            }
        }

        System.out.println("Total Hours : " + sum);
        System.out.println("Min Hours/day : " + minHours);
        System.out.println("Max Days : " + maxDays);
    }

    static float getMinHours(int totalHours, int days) {
        return (float) totalHours /days;
    }

    static int getMaxDays(int totalHours,int hoursPerDay) {
        return (int) Math.ceil((float) totalHours / hoursPerDay);
    }
}
