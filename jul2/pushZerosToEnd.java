class Solution {
    void pushZerosToEnd(int[] arr) {
        int pt1 = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[pt1];
                arr[pt1] = temp;
                pt1++;
            }
        }
    }
}
