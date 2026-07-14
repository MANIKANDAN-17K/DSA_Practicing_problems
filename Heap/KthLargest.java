class Solution {
    private static Random rand = new Random();
     static int generateRandomPvt(int l,int r){
        int len = r - l + 1;
        return rand.nextInt(len) + l;
    }
    static int PratitionByIdx(int[] arr,int pvt,int l,int r){
        int pivot = arr[pvt];
        int temp = arr[l];
        arr[l] = pivot;
        arr[pvt] = temp;
        int idx = l + 1;
        for(int i = l + 1;i<= r;i++){
            if(arr[i] > pivot){
                temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                idx++;
            }
        }
        int t = arr[l];
        arr[l] = arr[idx - 1];
        arr[idx - 1] = t;
        return idx - 1;
    }
    public static int KthLargest(int arr[], int k) {
        int r = arr.length - 1;
        int l = 0;
        while(true){
            int pvt = generateRandomPvt(l,r);
            pvt =  PratitionByIdx(arr,pvt,l,r);
            if(pvt == k - 1) return arr[pvt];
            else if(pvt > k - 1) r = pvt - 1;
            else l = pvt + 1;
        }
    }
}
