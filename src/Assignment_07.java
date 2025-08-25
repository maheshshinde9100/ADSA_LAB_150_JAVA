public class Assignment_07 {
    public static void main(String[] args) {
        int D = 18;
        int[] task = new int[]{9,10,12,9};
        float sum = 0;
        for(int i=0;i<task.length;i++){
            sum+= task[i];
        }
        float minHours = getMinHours(sum,D);
        float maxDays = getMaxDays(minHours,sum);

        System.out.println("Min Hours : "+minHours);
        System.out.println("MAX Days : "+maxDays);

    }
    static float getMinHours(float sum,float D){
        return (float) sum/D;
    }
    static float getMaxDays(float minHours,float sum){
        return (float) sum/minHours;
    }
}
