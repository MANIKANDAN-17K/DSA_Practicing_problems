class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0;i<n - 2;i++){
            int targ = target - arr[i];
            int l = i+1;
            int r = n - 1;
            while(l < r){
                if(arr[l] + arr[r] == targ){
                    return true;
                }else if(arr[l] + arr[r] < targ){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return false;
    }
}
