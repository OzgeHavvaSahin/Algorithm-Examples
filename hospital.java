 public class hospital {
 
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,7,8,10};
        System.out.println(findMissingPatient(arr));
    }
    public static int findMissingPatient(int[] A) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == mid + 1) {
                // The patient with id mid + 1 came to their appointment
                // Search in the right half for the missing patient
                low = mid + 1;
            } else {
                // The patient with id mid + 1 did not come to their appointment
                // Search in the left half for the missing patient
                high = mid - 1;
            }
        }

        // The first patient that did not come to their appointment is at index low + 1
        return low + 1;
    }

    
 }