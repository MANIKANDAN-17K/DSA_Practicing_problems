class Solution {
    static int merge(int[] a,int l,int m,int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] lt = new int[n1];
        int[] rt = new int[n2];
        for(int i = 0;i<n1;i++){
            lt[i] = a[i + l];
        }
        for(int j = 0;j<n2;j++){
            rt[j]=a[m + j + 1];
        }
        int i = 0,j=0,k=l;
        int res = 0;
        while (i< n1 && j <n2){
            if(lt[i] <= rt[j])    a[k++] = lt[i++];
            else{
                a[k++] = rt[j++];
                res += (n1 - i);
            }
        }
        while(i < n1) a[k++] = lt[i++];
        while(j < n2) a[k++] = rt[j++];
        return res;
    }
    static int invcnt(int[] arr, int l,int r){
        int res = 0;
        if(l < r){
            int m = (r + l)/2;
            res += invcnt(arr,l,m);
            res += invcnt(arr,m+1,r);
            res += merge(arr,l,m,r);
        }
        return res;
    }
    static int inversionCount(int arr[]) {
        return invcnt(arr,0,arr.length - 1);
    }
}
