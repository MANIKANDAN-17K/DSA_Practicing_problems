class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0;i<n;i++){
            int minIdx = i;
            for(int j = i + 1;j<n;j++){
                if(arr[minIdx] > arr[j])
                    minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
