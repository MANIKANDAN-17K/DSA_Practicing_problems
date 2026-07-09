class Solution {
    int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;
        for(int i = 0;i<arr.length;i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;
            pref = pref* arr[i];
            suff = arr[arr.length - i - 1] * suff;
            ans = Math.max(ans,Math.max(pref,suff));
        }
        return ans;
    }
}

