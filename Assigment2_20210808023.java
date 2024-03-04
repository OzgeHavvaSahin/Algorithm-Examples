import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assigment2_20210808023 {
    public static void main(String[] args) {
        Random random = new Random();
        int [] array8 = new int[8];
        int [] array16 = new int[16];
        int [] array32 = new int[32];
        
        for(int i = 0; i < array8.length; i++){
            array8[i] = random.nextInt(100);
        }

        for(int i = 0; i < array16.length; i++){
            array16[i] = random.nextInt(100);
        }

        for(int i = 0; i < array32.length; i++){
            array32[i] = random.nextInt(100);
        }


        System.out.println("Cutting the log problem time complexity analysis");

        long startof8 = System.nanoTime();
        cuttingTheLog(array8, array8.length);
        long endof8 = System.nanoTime();
        System.out.println("Array size = " + array8.length + " Time ="+ (endof8 - startof8) + " nanoseconds");

        long startof16 = System.nanoTime();
        cuttingTheLog(array16, array16.length);
        long endof16 = System.nanoTime();
        System.out.println("Array size = " + array16.length + " Time ="+ (endof16 - startof16) + " nanoseconds");

        long startof32 = System.nanoTime();
        cuttingTheLog(array32, array32.length);
        long endof32 = System.nanoTime();
        System.out.println("Array size = " + array32.length + " Time ="+ (endof32 - startof32) + " nanoseconds");

        System.out.println("Longest common subarray problem time complexity analysis");

        String str1 = "ABCDXYZjjk";
        String str2 = "XYZjjkABCD";
        String str3 = "ABDJFEOFĞEKLSDP"; 
        String str4 = "XYZjjkABCEOFĞEK";
        String str5 = "SDAPSDJOEJFOJEWPFJEF";
        String str6 = "SDDDDJOEJFOJEWPFJDCE";
       

        long startof10 = System.nanoTime();
        longestCommonSubarray(str1, str2, str1.length(), str2.length(), 0);
        long endof10 = System.nanoTime();
        System.out.println("String size = " + str1.length() + " Time ="+ (endof10 - startof10) + " nanoseconds");

        long startof15 = System.nanoTime();
        longestCommonSubarray(str3, str4, str3.length(), str4.length(), 0);
        long endof15 = System.nanoTime();
        System.out.println("String size = " + str3.length() + " Time ="+ (endof15 - startof15) + " nanoseconds");

        long startof20 = System.nanoTime();
        longestCommonSubarray(str5, str6, str5.length(), str6.length(), 0);
        long endof20 = System.nanoTime();
        System.out.println("String size = " + str5.length() + " Time ="+ (endof20 - startof20) + " nanoseconds");

    }

    public static int cuttingTheLog(int[] prices, int n) {
        int sum = Integer.MIN_VALUE;

        if (n == 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            sum = Math.max(sum, prices[i-1] + cuttingTheLog(prices, n-i));
            
        }
        
        return sum;
    }

    /*
     *  This method returns the pieces of the log that will be cut.
     *   public static List<Integer> cuttingTheLogPieces(int[] prices, int n) {
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        if (n == 0) {
            return result;
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> currentResult = cuttingTheLogPieces(prices, n - i);
            int current = prices[i - 1] + (currentResult.isEmpty() ? 0 : currentResult.get(0));

            if (current > max) {
                max = current;
                result.clear();
                result.add(i - 1); 
                result.addAll(currentResult); 
            }
        }

        return result;
    }
     */



    public static int longestCommonSubarray(String X, String Y, int m, int n, int count) {
        if(m == 0 || n == 0){
          return count;
        }

        if(X.charAt(m-1) == Y.charAt(n-1)){
          count = longestCommonSubarray(X, Y, m-1, n-1, count+1);
        }else{
            count = Math.max(count, Math.max(longestCommonSubarray(X, Y, m, n-1, 0), longestCommonSubarray(X, Y, m-1, n, 0)));
        }
        return count;
    }

    /*
     * This method returns the longest common subarray.
     *  public static String findLongestCommonSubstring(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return "";
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + findLongestCommonSubstring(s1, s2, i + 1, j + 1);
        } else {
            String side1 = findLongestCommonSubstring(s1, s2, i + 1, j);
            String side2 = findLongestCommonSubstring(s1, s2, i, j + 1);
            if(side1.length() > side2.length()){
                return side1;
            }else{
                return side2;
            }
        }
    }
     */
}
