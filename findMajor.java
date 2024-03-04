class findMajor{
    public static boolean isMajority(int[] arr, int a){
        int b = 0 ;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == a){ b ++; }
        }
        if(b >= arr.length / 2){ return true; }
        return false; 
    }

    public static int findMajority(int[] A , int l,int h) {
        if(l == h){ return A[l]; }
        int mid = (l+h) / 2;
        int left = findMajority(A,l,mid);
        int right = findMajority(A, mid+1,h);
        if(isMajority(A,left)){ return left; }
        if(isMajority(A, right)){ return right; }
        return -1;
    }
}
