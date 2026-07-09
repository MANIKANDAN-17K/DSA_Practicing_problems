class Solution {
    int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int sum = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(sum < 0){
                sum = 0;
            }
            sum = sum+arr[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
