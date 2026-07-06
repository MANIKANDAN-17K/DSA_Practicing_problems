class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int prod = 1;
        int idx = - 1;
        int zero = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == 0){
                idx = i;
                zero++;
            }else{
                prod *= arr[i];
            }
        }
        int[] res = new int[n];
        Arrays.fill(res,0);
        if(zero>1){
            return res;    
        }
        else if(idx > -1){
            for(int i = 0;i<n;i++){
                res[i] = 0;
            }
            res[idx] = prod;
        }else{
            for(int i = 0;i<n;i++){
                res[i] = prod / arr[i];
            }
        }
        return res;
    }
}
