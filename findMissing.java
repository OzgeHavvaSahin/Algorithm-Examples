import java.util.Arrays;

class deneme{
    public static void main(String[] args) {
        int[] arr = {16,3,9,5,4,13,1,6,7,8,2};
        System.out.println(findMiss(arr));
    }
    static int findMiss(int[] arr) {
        Arrays.sort(arr);
        int miss = -1;
        
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]+1 != arr[i+1]){
                miss = arr[i]+1;
                break;
            }
        }
        return miss;
    }
}