class Solution {
    public int maxWater(int arr[]) {
        int res = 0;
        int left = 1;
        int right = arr.length - 2;
        int maxL = arr[left - 1];
        int maxR = arr[right + 1];
        while(left <= right){
            if(maxL >= maxR){
                res += Math.max(0,maxR - arr[right]);
                maxR = Math.max(maxR,arr[right]);
                right--;
            }else{
                res += Math.max(0,maxL - arr[left]);
                maxL = Math.max(maxL,arr[left]);
                left++;
            }
        }
        return res;
    }
}
