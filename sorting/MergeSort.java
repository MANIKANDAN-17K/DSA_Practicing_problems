class Solution {
    private void merge(int[] arr,int l,int m,int r){
        int n1 = m - l+ 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0;i<n1;i++) left[i] = arr[i+l];
        for(int i = 0;i<n2;i++) right[i] = arr[m + i + 1];
        int i = 0,k = l,j = 0;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while(i < n1) arr[k++] = left[i++];
        while(j < n2) arr[k++] = right[j++];
    }
    public void mergeSort(int arr[], int l, int r) {
        if(l<r){
            int m = l + (r - l) / 2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
}
