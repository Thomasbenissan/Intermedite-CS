import java.lang.Math;

public class MinDiff {

    public static void main(String[] args) throws Exception {
        int[] intArray1 = { 1, 34, 4, 6, 14, 2 };
        int ans1 = minDiff(intArray1); // Should be 2 as |4 - 6| = 2;
        System.out.println("Min Diff of {1, 34, 4, 6, 14, 2} is: " + ans1);

        int[] intArray2 = { 23, 15, 46, 75, 6, 74, 100 };
        int ans2 = minDiff(intArray2); // Should be 8 as |23 - 15| = 8;
        System.out.println("Min Diff of {23, 15, 46, 75, 6, 74, 100} is: " + ans2);

    }

    public static int minDiff(int[] stones){
        int num = stones[0];
        int total = 2000000;
        for(int i = 1; i < stones.length; i++){
            if(Math.abs(stones[i]-num) <= total){
                total = (Math.abs(stones[i]-num));
            }
            num = stones[i];
        }
        return total;
    }

}